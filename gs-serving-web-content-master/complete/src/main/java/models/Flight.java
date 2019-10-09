package models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Flight implements Serializable {
    @JsonProperty("airline")
    public String airline;

    @JsonProperty("flightNumber")
    public String flightNumber;
}
