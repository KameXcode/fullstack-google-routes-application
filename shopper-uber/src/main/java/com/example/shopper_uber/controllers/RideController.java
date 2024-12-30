package com.example.shopper_uber.controllers;

import com.example.shopper_uber.dtos.ConfirmDto;
import com.example.shopper_uber.dtos.OriginDestinationDto;
import com.example.shopper_uber.entities.DriverEntity;
import com.example.shopper_uber.entities.RideEntity;
import com.example.shopper_uber.repositories.DriverRepository;
import com.example.shopper_uber.repositories.GetRideRepository;
import com.example.shopper_uber.repositories.RideRepository;
import com.example.shopper_uber.services.DriversAvailableService;
import com.example.shopper_uber.services.EstimateValueService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ride")
public class RideController {

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    EstimateValueService estimateValueService;

    @Autowired
    DriversAvailableService driversAvailableService;

    @Autowired
    GetRideRepository getRideRepository;

    @Autowired
    RideRepository rideRepository;


    @PostMapping("/estimate")
    public ResponseEntity EstimateValueController(@RequestBody OriginDestinationDto originDestinationDto){
        if (originDestinationDto.getOrigin().isBlank() || originDestinationDto.getDestination().isBlank()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Os campos não podem estar vazios");
        }
        EstimateValueService.EstimateRoute estimateRoute = estimateValueService
                .estimateRouteApi(originDestinationDto.getOrigin(),originDestinationDto.getDestination());

        List<DriverEntity> driverEntities = driversAvailableService
                .driverAvailable(estimateRoute.getDistanceMeters());
        estimateRoute.setOptions(driverEntities);
        return ResponseEntity.status(HttpStatus.OK).body(estimateRoute);
    }

    @PostMapping("/confirm")
    public ResponseEntity ConfirmController(@RequestBody ConfirmDto confirmDto) {
        try{
            var rideEntity = new RideEntity();
            BeanUtils.copyProperties(confirmDto, rideEntity);
            rideRepository.save(rideEntity);
            return ResponseEntity.status(HttpStatus.OK).body("");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("An error occurred while creating the ride: " + e.getMessage());
        }
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity getRide(@PathVariable(value = "customer_id")Integer customer_id, @RequestParam(required = false) Integer driver_id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(rideRepository.findRideDtoByCustomer_id(customer_id, driver_id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while creating the ride: " + e.getMessage());
        }
    }



}
