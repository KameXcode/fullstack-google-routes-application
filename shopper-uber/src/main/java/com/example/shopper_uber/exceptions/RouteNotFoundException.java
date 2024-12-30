package com.example.shopper_uber.exceptions;

public class RouteNotFoundException  extends  RuntimeException{
    public RouteNotFoundException() {super("Nenhuma rota encontrada");}
}
