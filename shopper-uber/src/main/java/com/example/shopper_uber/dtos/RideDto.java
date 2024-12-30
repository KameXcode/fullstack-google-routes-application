package com.example.shopper_uber.dtos;

public class RideDto {
    private Integer ride_id;
    private Integer customer_id;
    private String origin;
    private String destination;
    private Integer distance;
    private String duration;
    private Integer valor;
    private Driver driver;

    public RideDto(Integer ride_id, Integer customer_id, String origin, String destination, Integer distance, String duration, Integer valor, Integer driver_id, String driver_name) {
        this.ride_id = ride_id;
        this.customer_id = customer_id;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.duration = duration;
        this.valor = valor;
        this.driver = new Driver(driver_id, driver_name);
    }

    public Integer getRide_id() {
        return ride_id;
    }

    public void setRide_id(Integer ride_id) {
        this.ride_id = ride_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
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

    public void setDestination(String destination) {
        this.destination = destination;
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public static class Driver{
        private Integer driver_id;
        private String nome;

        public Driver(Integer driver_id, String nome) {
            this.driver_id = driver_id;
            this.nome = nome;
        }


        public Integer getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(Integer driver_id) {
            this.driver_id = driver_id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }

}
