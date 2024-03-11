package ca.bc.gov.wildfirewatch.service;

import ca.bc.gov.wildfirewatch.model.FirePointResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * Service class for fetching fire points data from an external API.
 */
@Service
public class FirePointService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Retrieves fire points data from the external API.
     *
     * @param fireStatus            The fire status for filtering fire points data.
     * @param fireCause             The fire cause for filtering fire points data.
     * @param geographicDescription The geographic description for filtering fire points data.
     * @return The response containing fire points data.
     */
    public FirePointResponse getFirePoints( String fireStatus, String fireCause, String geographicDescription) {
        UriComponentsBuilder builder = buildUriComponents();
        StringBuilder cqlFilter = new StringBuilder();

        if (StringUtils.isNotBlank(fireStatus)) {
            cqlFilter.append("FIRE_STATUS='").append(fireStatus).append("' AND ");
        }
        if (StringUtils.isNotBlank(fireCause)) {
            cqlFilter.append("FIRE_CAUSE='").append(fireCause).append("' AND ");
        }
        if (StringUtils.isNotBlank(geographicDescription)) {
            cqlFilter.append("GEOGRAPHIC_DESCRIPTION='").append(geographicDescription).append("' AND ");
        }
        if (cqlFilter.length() > 0) {
            cqlFilter.setLength(cqlFilter.length() - 5); // Remove the last " AND "
            builder.queryParam("cql_filter", cqlFilter.toString());
        }

        String url = null;
        try {
            url = URLDecoder.decode(builder.toUriString(), StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(url);
        // Check if data exists in cache
        if (redisTemplate.opsForHash().hasKey("firePointsCache", url)) {
            System.out.println("Call cash");
            return (FirePointResponse) redisTemplate.opsForHash().get("firePointsCache", url);
        } else {
            FirePointResponse firePoints = null;
            System.out.println("test");
            System.out.println(url);
            firePoints = restTemplate.getForObject(url, FirePointResponse.class);
            if (firePoints!= null){
                // Put data into cache
                redisTemplate.opsForHash().put("firePointsCache", url, firePoints);
            }

            return firePoints;
        }
    }

    // Method to create UriComponentsBuilder instance
    protected UriComponentsBuilder buildUriComponents() {
        return UriComponentsBuilder.fromHttpUrl("https://openmaps.gov.bc.ca/geo/pub/ows")
                .queryParam("service", "WFS")
                .queryParam("version", "2.0.0")
                .queryParam("request", "GetFeature")
                .queryParam("typeName", "pub:WHSE_LAND_AND_NATURAL_RESOURCE.PROT_CURRENT_FIRE_PNTS_SP")
                .queryParam("outputFormat", "application/json");
    }
}