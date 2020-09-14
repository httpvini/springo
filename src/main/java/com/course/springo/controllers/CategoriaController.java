package com.course.springo.controllers;

import com.course.springo.domain.Categoria;
import com.course.springo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscar(@PathVariable Integer id) {
        Categoria categoria = categoriaService.buscar(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }
}
