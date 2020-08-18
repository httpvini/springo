package com.course.springo.services;

import com.course.springo.domain.Categoria;
import com.course.springo.repositories.CategoriaRepository;
import com.course.springo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: "+ id +", Tipo: "+Categoria.class.getName()));
    }

}
