package com.course.springo.controllers;

import com.course.springo.domain.Categoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @GetMapping("/listar")
    public ResponseEntity<Object> listar() {
        List<Categoria> categorias = new ArrayList<>(
                Arrays.asList(
                        new Categoria(1, "Informatica"),
                        new Categoria(2, "Escritorio")
                ));
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
}
