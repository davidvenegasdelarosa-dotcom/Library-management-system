package com.example.demo.model;
import jakarta.persistence.*;

public class Libro{
    private Long id;
    private String titulo;
    public Libro(){};
    public Libro(Long id_, String titulo_){ //Constructor de un libro
        this.id=id_;
        this.titulo=titulo_;
    }
    public String mostrar_titulo(){
        return(this.titulo);
    }
    public String mostrar_id(){
        return(this.id);
    }
    
}