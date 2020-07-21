package com.course.springo.utils;

import com.course.springo.domain.Categoria;
import com.course.springo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FillUpDatabase {

    @Autowired
    private CategoriaRepository repo;


    List<Categoria> categorias = new ArrayList<>(
            Arrays.asList(
                    new Categoria(null, "Informatica"),
                    new Categoria(null, "Escritorio")
            )
    );

    public CategoriaRepository getRepo() {
        return repo;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }
}
