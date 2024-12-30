package com.example.shopper_uber.repositories;

import com.example.shopper_uber.dtos.RideDto;
import com.example.shopper_uber.entities.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepository extends JpaRepository<RideEntity, Integer> {

    @Query(nativeQuery = true)
    List<RideDto> findRideDtoByCustomer_id(Integer customer_id, Integer driver_id);

}
