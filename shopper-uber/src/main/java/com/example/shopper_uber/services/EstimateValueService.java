package com.example.shopper_uber.services;
import com.example.shopper_uber.entities.DriverEntity;
import com.example.shopper_uber.exceptions.RouteNotFoundException;
import com.example.shopper_uber.requests.RouteRequest;
import com.example.shopper_uber.responses.ResponseRoutes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EstimateValueService {

    @Value("${API.KEY}")
    private String API_KEY;

    public String getAPI_KEY() {
        return API_KEY;
    }

    public EstimateRoute estimateRouteApi(String origin, String destination){
        String url ="https://routes.googleapis.com/directions/v2:computeRoutes?key="+getAPI_KEY();
        RouteRequest routeRequest = new RouteRequest(new RouteRequest.Origin(origin), new RouteRequest.Destination(destination));
        WebClient webClient = WebClient.create(url);
        ResponseRoutes responseRoutes = webClient.post().contentType(MediaType.APPLICATION_JSON).header("X-Goog-FieldMask","routes.distanceMeters,routes.duration,routes.legs.startLocation,routes.legs.endLocation").bodyValue(routeRequest).retrieve().bodyToMono(ResponseRoutes.class).block();

        if (responseRoutes.getRoutes() != null){
            EstimateValueService.EstimateRoute estimateRouteObject = new EstimateRoute(responseRoutes.getRoutes().get(0).getDistanceMeters(),responseRoutes.getRoutes().get(0).getDuration(),responseRoutes.getRoutes().get(0).getLegs().get(0).getStartLocation().getLatLng(),responseRoutes.getRoutes().get(0).getLegs().get(0).getEndLocation().getLatLng());
            return estimateRouteObject;
        }
        else {
            throw new RouteNotFoundException();
        }

    }
    public static class EstimateRoute{
        int distanceMeters;
        String duration;
        ResponseRoutes.Routes.Legs.LatLng startLocation;
        ResponseRoutes.Routes.Legs.LatLng endLocation;
        List<DriverEntity> options;

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

        public ResponseRoutes.Routes.Legs.LatLng getStartLocation() {
            return startLocation;
        }

        public void setStartLocation(ResponseRoutes.Routes.Legs.LatLng startLocation) {
            this.startLocation = startLocation;
        }

        public ResponseRoutes.Routes.Legs.LatLng getEndLocation() {
            return endLocation;
        }

        public void setEndLocation(ResponseRoutes.Routes.Legs.LatLng endLocation) {
            this.endLocation = endLocation;
        }

        public List<DriverEntity> getOptions() {
            return options;
        }

        public void setOptions(List<DriverEntity> options) {
            this.options = options;
        }

        public EstimateRoute(int distanceMeters, String duration, ResponseRoutes.Routes.Legs.LatLng startLocation, ResponseRoutes.Routes.Legs.LatLng endLocation) {
            this.distanceMeters = distanceMeters;
            this.duration = duration;
            this.startLocation = startLocation;
            this.endLocation = endLocation;
        }

    }
}
