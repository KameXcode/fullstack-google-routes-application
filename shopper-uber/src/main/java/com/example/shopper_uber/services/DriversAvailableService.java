package com.example.shopper_uber.services;

import com.example.shopper_uber.entities.DriverEntity;
import com.example.shopper_uber.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriversAvailableService {

    @Autowired
    DriverRepository driverRepository;

    public List<DriverEntity> driverAvailable(int distanceMeters){
        List<DriverEntity> driversAvailable = new ArrayList<DriverEntity>();
        int kilometers = distanceMeters/1000;
        List<DriverEntity> drivers = driverRepository.findAll();
        for (int i = 0; i < drivers.size(); i++){
                if (drivers.get(i).getKm_minimo() <= distanceMeters){
                    drivers.get(i).setValor(drivers.get(i).getTaxa_km()*kilometers);
                    driversAvailable.add(drivers.get(i));
                }
        }
        return driversAvailable;
    }
}
