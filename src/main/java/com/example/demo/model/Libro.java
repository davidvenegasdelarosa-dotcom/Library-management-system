package com.example.demo.model;
import jakarta.persistence.*;

@Entity //convertimos la clase en una tabla de base de datos
public class Libro{

    @Id //La variable "id" es la que distingue un libro de otro
    @GeneratedValue(strategy = GenerationType.IDENTITY) //si el ultimo libro tenia un id igual a 5, el siguiente sera con el id igual a 6
    private Long id;
    private String titulo;
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
