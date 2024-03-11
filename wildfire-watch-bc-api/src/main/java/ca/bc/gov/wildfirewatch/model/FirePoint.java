package ca.bc.gov.wildfirewatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Represents a single fire point obtained from the BC Wildfire API.
 * Contains information about properties and geometry of the fire point.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class FirePoint implements Serializable {

    /**
     * The type of the fire point.
     */
    @JsonProperty("type")
    private String type;

    /**
     * Properties of the fire point including its ID, name, cause, and status.
     */
    @JsonProperty("properties")
    private FirePointProperties properties;

    /**
     * Geometry of the fire point including its type and coordinates.
     */
    @JsonProperty("geometry")
    private FirePointGeometry geometry;
}
