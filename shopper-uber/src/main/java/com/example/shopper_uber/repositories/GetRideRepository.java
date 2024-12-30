package com.example.shopper_uber.repositories;

import com.example.shopper_uber.dtos.RideDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GetRideRepository {
    @PersistenceContext
    private EntityManager em;

    public List<RideDto> findAllRides(Integer customerId){
        String query = "SELECT r.ride_id, r.customer_id, r.origin, r.destination, r.distance, r.duration, r.valor, r.driver_id, d.nome AS driver_name "
                + "FROM rides r " +
                "JOIN drivers d " +
                "ON r.driver_id = d.id " +
                "WHERE r.customer_id = :customer_id";
        TypedQuery<RideDto> typedQuery = em.createQuery(query, RideDto.class);
        typedQuery.setParameter("customer_id", customerId);
        return typedQuery.getResultList();
    }
}
