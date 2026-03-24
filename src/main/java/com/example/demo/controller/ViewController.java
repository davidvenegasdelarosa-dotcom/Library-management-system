package com.example.demo.controller;

import com.example.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController{
    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/libros")
    public String PaginaPrincipal(Model model){
        model.addAttribute("libros", libroRepository.findAll());
        return "index";
    }
}
