package com.example.shopper_uber.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RouteRequest {
    @JsonProperty("origin")
    Origin origin;
    @JsonProperty("destination")
    Destination destination;
    @JsonProperty("travelMode")
    String travelMode = "DRIVE";
    @JsonProperty("units")
    String units = "METRIC";

    public RouteRequest(Origin origin, Destination destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public String getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public static class Origin{
        public Origin(String adress) {
            this.address = adress;
        }

        @JsonProperty("address")
        String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String adress) {
            this.address = adress;
        }
    }
    public static class Destination{
        public Destination(String adress) {
            this.address = adress;
        }
        @JsonProperty("address")
        String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String adress) {
            this.address = adress;
        }
    }

}
