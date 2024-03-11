package ca.bc.gov.wildfirewatch.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * Client for interacting with the OpenMap service.
 */
@Component
public class OpenMapClient {
    /**
     * Provides a customized RestTemplate for making HTTP requests to the OpenMap service.
     *
     * @param builder RestTemplateBuilder used to build the RestTemplate instance
     * @return RestTemplate configured for interacting with the OpenMap service
     */
    @Bean(name = "openMapRestTemplate")
    public RestTemplate getRestClient(RestTemplateBuilder builder) {
        return builder
                // Set connection and read timeouts to 100 seconds
                .setConnectTimeout(Duration.ofMillis(100000))
                .setReadTimeout(Duration.ofMillis(100000))
                // Add custom interceptors to modify HTTP request headers
                .additionalInterceptors((httpRequest, bytes, clientHttpRequestExecution) -> {
                    // Remove default headers and set Content-Type to JSON
                    httpRequest.getHeaders().remove(HttpHeaders.ACCEPT);
                    httpRequest.getHeaders().remove(HttpHeaders.CONTENT_LENGTH);
                    httpRequest.getHeaders().remove(HttpHeaders.CONTENT_TYPE);
                    httpRequest.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                    return clientHttpRequestExecution.execute(httpRequest, bytes);
                })
                .build();
    }
}