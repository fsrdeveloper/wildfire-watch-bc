package ca.bc.gov.wildfirewatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Represents the geometry of a single fire point obtained from the BC Wildfire API.
 * Contains the type of geometry and its coordinates.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class FirePointGeometry implements Serializable {

    /**
     * The type of the geometry.
     */
    @JsonProperty("type")
    private String type;

    /**
     * The coordinates of the geometry.
     */
    @JsonProperty("coordinates")
    private List<Double> coordinates;
}