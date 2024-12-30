package com.example.shopper_uber.responses;

import java.util.List;

public class ResponseRoutes {
    List<Routes> routes;

    public List<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }
    public static class Routes{
        List<Legs> legs;
        int distanceMeters;
        String duration;

        public int getDistanceMeters() {
            return distanceMeters;
        }

        public void setDistanceMeters(int distanceMeters) {
            this.distanceMeters = distanceMeters;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public List<Legs> getLegs() {
            return legs;
        }

        public void setLegs(List<Legs> legs) {
            this.legs = legs;
        }

        public static class Legs{
            public StartLocation getStartLocation() {
                return startLocation;
            }

            public void setStartLocation(StartLocation startLocation) {
                this.startLocation = startLocation;
            }

            public EndLocation getEndLocation() {
                return endLocation;
            }

            public void setEndLocation(EndLocation endLocation) {
                this.endLocation = endLocation;
            }

            StartLocation startLocation;
            EndLocation endLocation;

            public static class StartLocation{
                public LatLng getLatLng() {
                    return latLng;
                }

                public void setLatLng(LatLng latLng) {
                    this.latLng = latLng;
                }

                LatLng latLng;
            }
            public static class EndLocation{
                public LatLng getLatLng() {
                    return latLng;
                }

                public void setLatLng(LatLng latLng) {
                    this.latLng = latLng;
                }

                LatLng latLng;
            }
            public static class LatLng{
                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }

                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }

                String latitude;
                String longitude;
            }
        }
    }
}
