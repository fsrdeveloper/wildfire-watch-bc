package ca.bc.gov.wildfirewatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.io.Serializable;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

/**
 * Represents the response structure obtained from the BC Wildfire API.
 * Contains information about the type of response and a list of fire points.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@RedisHash("FirePointResponse")
public class FirePointResponse  implements Serializable{

    /**
     * The type of the response.
     */
    @JsonProperty("type")
    private String type;

    /**
     * List of fire points retrieved from the API response.
     */
    @JsonProperty("features")
    private List<FirePoint> firePoints;
}
