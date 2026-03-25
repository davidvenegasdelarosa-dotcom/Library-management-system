package com.example.demo.repository;
import com.example.demo.model.Libro; //Importamos la clase libro
import org.springframework.data.jpa.repository.JpaRepository; //Biblioteca con ciertas funciones importantes
import org.springframework.stereotype.Repository; //Etiqueta de spring
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long>{ //Creamos un repositorio de la clase libro, cuya variable primaria es de tipo Long
    //No escribimos nada aqui, ya heredamos de JpaRepository métodos como deleteById() y demás
    List<Libro> findByAutorContainingIgnoreCase(String autor_);
}

