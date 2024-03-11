package ca.bc.gov.wildfirewatch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Represents the properties of a single fire point obtained from the BC Wildfire API.
 * Contains attributes such as ID, name, cause, and status.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class FirePointProperties implements Serializable {

    @JsonProperty("FIRE_NUMBER")
    private String fireNumber;

    @JsonProperty("FIRE_YEAR")
    private int fireYear;

    @JsonProperty("RESPONSE_TYPE_DESC")
    private String responseTypeDesc;

    @JsonProperty("IGNITION_DATE")
    private String ignitionDate;

    @JsonProperty("FIRE_OUT_DATE")
    private String fireOutDate;

    @JsonProperty("FIRE_STATUS")
    private String fireStatus;

    @JsonProperty("FIRE_CAUSE")
    private String fireCause;

    @JsonProperty("FIRE_CENTRE")
    private int fireCentre;

    @JsonProperty("ZONE")
    private int zone;

    @JsonProperty("FIRE_ID")
    private int fireId;

    @JsonProperty("FIRE_TYPE")
    private String fireType;

    @JsonProperty("INCIDENT_NAME")
    private String incidentName;

    @JsonProperty("GEOGRAPHIC_DESCRIPTION")
    private String geographicDescription;

    @JsonProperty("LATITUDE")
    private double latitude;

    @JsonProperty("LONGITUDE")
    private double longitude;

    @JsonProperty("CURRENT_SIZE")
    private double currentSize;

    @JsonProperty("FIRE_URL")
    private String fireUrl;
}
