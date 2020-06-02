package com.course.springo.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class Categoria {

    @GetMapping("/listar")
    public String listar(){
        return "Spring boot running";
    }
}
