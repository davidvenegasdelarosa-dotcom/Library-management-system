package com.example.demo.controller;

import com.example.demo.repository.LibroRepository;
import com.example.demo.service.LibroService;
import com.example.demo.model.Libro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/filtrar")
    public String libros_por_autor(String autor_, Model model){
        List<Libro> lista = libroService.filtrar_por_autor(autor_);
        model.addAttribute("libros", lista);
        return "index";
    }

    @GetMapping("/delete/{idd}") //Realmente es un DeleteMapping, pero lo "engañamos" para que se pueda usar su url como usuario
    public String eliminar_por_id(@PathVariable Long idd){
        //Comprobamos que el libro este en la base de datos antes de intentar borrarlo
        if(libroRepository.existsById(idd)) libroRepository.deleteById(idd);
        return "redirect:/libros";
    }

    @GetMapping("/add/{autor_}/{nombre_}")
    public String añadir_libro(@PathVariable String autor_, @PathVariable String nombre_){
        Libro libro = new Libro();
        libro.Libro_sinId(nombre_, autor_);
        libroRepository.save(libro);
        return "redirect:/libros";
    }
}
