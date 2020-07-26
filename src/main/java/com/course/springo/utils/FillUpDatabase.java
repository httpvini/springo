package com.course.springo.utils;

import com.course.springo.domain.Categoria;
import com.course.springo.domain.Produto;
import com.course.springo.repositories.CategoriaRepository;
import com.course.springo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FillUpDatabase {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;


    private Categoria categoriaInformatica = new Categoria(null, "Informatica");
    private Categoria categoriaEscritorio = new Categoria(null, "Escritorio");

    private Produto computador = new Produto(null, "Computador", 900.00);
    private Produto impressora = new Produto(null, "Impressora", 200.00);
    private Produto mouse = new Produto(null, "Mouse", 100.00);

    public void fillUp() {
        associaProdutocategoria();
        categoriaRepository.saveAll(Arrays.asList(categoriaEscritorio, categoriaInformatica));
        produtoRepository.saveAll(Arrays.asList(computador, impressora, mouse));
    }

    private void associaProdutocategoria() {
        categoriaInformatica.getProdutos().addAll(
                Arrays.asList(
                        computador,
                        impressora,
                        mouse
                )
        );
        categoriaEscritorio.getProdutos().add(impressora);

        computador.getCategorias().add(categoriaInformatica);
        impressora.getCategorias()
                .addAll(
                        Arrays.asList(
                                categoriaInformatica,
                                categoriaEscritorio
                        )
                );
        mouse.getCategorias().add(categoriaInformatica);
    }
}
