package com.example.demo.controller;
import com.example.demo.model.Libro;
import com.example.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired; //Importamos el objeto ya creado de libro sin tener qe declararla aqui (como haríamos en c++)
import org.springframework.web.bind.annotation.*; //Importamos todas las etiquetas que necesitamos, como ya indica el *
import java.util.List; //Biblioteca con los metodos de Lista implementada con celdas enlazadas


@RestController
@RequestMapping("/api/libros")
public class LibroController{
    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/api/libros")
    public List<Libro> mostrar_libros(){
        return libroRepository.findAll(); //Devolvemos una lista dinamica con todos los libros de la base de datos
    }

    @PostMapping("/api/libros")
    public Libro guardar_libro(Libro libro){
        return libroRepository.save(libro);
    }

    @GetMapping("{idd}")
    public Libro buscar_por_id(@PathVariable Long idd){
        return libroRepository.findById(idd).orElse(null);
    }

    @DeleteMapping("{idd}")
    public void eliminar_por_id(@PathVariable Long idd){
        if(libroRepository.existsById(idd)){ //Comprobamos que el libro este en la base de datos antes de intentar borrarlo
            libroRepository.deleteById(idd);
            System.out.println("El libro con el id " + idd + " ha sido eliminado satisfactoriamente");
        } else System.out.println("No hay ningún libro que corresponda al id: " + idd + "\n");
    }
}
    
