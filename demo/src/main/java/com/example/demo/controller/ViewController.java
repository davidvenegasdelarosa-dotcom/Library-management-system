package com.example.demo.controller;

import com.example.demo.repository.LibroRepository;
import com.example.demo.service.LibroService;
import com.example.demo.model.Libro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController{
    @Autowired
    private LibroRepository libroRepository;
    @Autowired //Para crear el objeto de forma automática
    private LibroService libroService;

    @GetMapping("/libros")
    public String PaginaPrincipal(Model model){
        model.addAttribute("libros", libroRepository.findAll());
        return "index";
    }

    @GetMapping("/libros/filtrar")
    public String libros_por_autor(String autor_, Model model){
        List<Libro> lista = libroService.filtrar_por_autor(autor_);
        model.addAttribute("libros", lista);
        return "index";
    }

    @DeleteMapping("/libros/delete/{idd}")
    @ResponseBody //No devovlemos un html, sino una confirmación
    public ResponseEntity<String> eliminar_por_id(@PathVariable Long idd){
        try{
            if(libroRepository.existsById(idd)){
                libroRepository.deleteById(idd);
                return ResponseEntity.ok("El libro eliminado exitosamente");
            } else{ //Si el libro no existe, avisamos al frontend con un error 404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El libro con ID" + idd + " no existe");
            }

        } catch(Exception e){ //Si hay un error tecnica al internat manipular la BD, lanzamos un error 500
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error técnico al intentar borrar");
        }
    }

    @PostMapping("/libros/add")
    @ResponseBody
    public ResponseEntity<?> añadir_libro(@RequestParam String autor_, @RequestParam String titulo){
        try{
            if(!libroRepository.existsByTituloAndAutor(titulo, autor_)){//nos aseguramos de que no hubiese un libro identico a este en la base de datos
            Libro libro = new Libro();
            libro.Libro_sinId(titulo, autor_);
            Libro guardado = libroRepository.save(libro);
            return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
            } else return ResponseEntity.status(HttpStatus.CONFLICT).body("Este libro ya existe en la biblioteca");
         } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al conectar con la base de datos");
         }
    }
}
