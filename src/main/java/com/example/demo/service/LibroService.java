package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.LibroRepository;
import com.example.demo.model.Libro;

@Service
public class LibroService{
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> obtener_todos(){
        return libroRepository.findAll();
    }

    public List<Libro> filtrar_por_autor(String autor_){
        List<Libro> listilla;
        if(autor_!=null && !autor_.isEmpty()) listilla=libroRepository.findByAutorContainingIgnoreCase(autor_);
        else listilla=libroRepository.findAll(); //hola
        return listilla;
    }
}
