package com.example.shopper_uber.entities;

import com.example.shopper_uber.dtos.RideDto;
import jakarta.persistence.*;

@Entity(name="ride")
@NamedNativeQuery(name = "RideEntity.findRideDtoByCustomer_id",
        query = "SELECT r.ride_id, r.customer_id, r.origin, r.destination, r.distance, r.duration, r.valor, r.driver_id, d.nome AS driver_name "
                + "FROM rides r " +
                "JOIN drivers d " +
                "ON r.driver_id = d.id " +
                "WHERE r.customer_id = :customer_id "+ "AND (:driver_id IS NULL OR r.driver_id = :driver_id)",
        resultSetMapping = "Mapping findRideDtoByCustomer_id"
)

@SqlResultSetMapping(
        name = "Mapping findRideDtoByCustomer_id",
        classes = @ConstructorResult(
                targetClass = RideDto.class,
                columns = {
                        @ColumnResult(name = "ride_id", type = Integer.class),
                        @ColumnResult(name = "customer_id", type = Integer.class),
                        @ColumnResult(name = "origin", type = String.class),
                        @ColumnResult(name = "destination", type = String.class),
                        @ColumnResult(name = "distance", type = Integer.class),
                        @ColumnResult(name = "duration", type = String.class),
                        @ColumnResult(name = "valor", type = Integer.class),
                        @ColumnResult(name = "driver_id", type = Integer.class),
                        @ColumnResult(name = "driver_name", type = String.class)
                }
        )
)


@Table(name="rides")
public class RideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ride_id")
    private Integer ride;

    @Column(name = "customer_id") // Aqui você pode manter o nome da coluna como "customer_id"
    private Integer customer;

    private String origin;

    private String destination;

    private Integer distance;

    private String duration;

    private Integer valor;

    private Integer driver_id;

    public Integer getRide() {
        return ride;
    }

    public void setRide(Integer ride) {
        this.ride = ride;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destiny) {
        this.destination = destiny;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
    }
}
