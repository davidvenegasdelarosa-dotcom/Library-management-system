package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // <--- ¡Esta línea es la brújula de Maven!
@ComponentScan(basePackages = {"com.example.demo", "com.exmple.demo.controller"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @GetMapping("/hola") // Una ruta super simple
    public String hola() {
        return "Si ves esto, el servidor funciona, pero no ve tus otros archivos";
    }
}