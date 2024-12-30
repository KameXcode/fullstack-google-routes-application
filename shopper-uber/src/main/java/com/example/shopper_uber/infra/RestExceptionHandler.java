package com.example.shopper_uber.infra;

import com.example.shopper_uber.exceptions.RouteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RouteNotFoundException.class)
    ResponseEntity<String> routeNotFoundHandler(RouteNotFoundException routeNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma rota foi encontrada");
    }
}
