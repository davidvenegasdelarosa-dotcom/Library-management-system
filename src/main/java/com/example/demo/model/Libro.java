package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity //convertimos la clase en una tabla de base de datos
public class Libro{

    @Id //La variable "id" es la que distingue un libro de otro
    @GeneratedValue(strategy = GenerationType.IDENTITY) //si el ultimo libro tenia un id igual a 5, el siguiente sera con el id igual a 6
    private Long id;
    @NotBlank(message = "El autor no puede estar vacío")
    private String titulo;
    @NotBlank(message = "El autor no puede estar vacío")
    private String autor;
    public Libro(){};
    public void Libro_sinId(){};
    public Libro(Long id_, String titulo_, String autor_){ //Constructor de un libro
        this.id=id_;
        this.titulo=titulo_;
        this.autor=autor_;
    }

    public void Libro_sinId(String titulo_, String autor_){
        this.titulo=titulo_;
        this.autor=autor_;
    }
    
	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}

}
