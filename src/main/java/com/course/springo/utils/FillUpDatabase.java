package com.course.springo.utils;

import com.course.springo.domain.Categoria;
import com.course.springo.domain.Cidade;
import com.course.springo.domain.Estado;
import com.course.springo.domain.Produto;
import com.course.springo.repositories.CategoriaRepository;
import com.course.springo.repositories.CidadeRepository;
import com.course.springo.repositories.EstadoRepository;
import com.course.springo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FillUpDatabase {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    List<Categoria> categorias = new ArrayList<>(Arrays.asList(
            new Categoria(null, "Informatica"),
            new Categoria(null, "Escritorio")
    ));

    List<Produto> produtos = new ArrayList<>(Arrays.asList(
            new Produto(null, "Computador", 900.00),
            new Produto(null, "Impressora", 200.00),
            new Produto(null, "Mouse", 100.00)
    ));

    List<Estado> estados = new ArrayList<>(Arrays.asList(
            new Estado(null, "Minas Gerais"),
            new Estado(null, "São Paulo")
    ));

    List<Cidade> cidades = new ArrayList<>(Arrays.asList(
            new Cidade(null, "Uberlândia", estados.get(0)),
            new Cidade(null, "São Paulo", estados.get(1)),
            new Cidade(null, "Campinas", estados.get(1))
    ));

    public void fillUp() {
        associaProdutocategoria();
        categoriaRepository.saveAll(categorias);
        produtoRepository.saveAll(produtos);
        estadoRepository.saveAll(estados);
        cidadeRepository.saveAll(cidades);
    }

    private void associaProdutocategoria() {

        Categoria categoriaInformatica = categorias.get(0);
        Categoria categoriaEscritorio = categorias.get(1);

        Produto computador = produtos.get(0);
        Produto impressora = produtos.get(1);
        Produto mouse = produtos.get(2);

        Estado minasGerais = estados.get(0);
        Estado saoPaulo = estados.get(1);

        Cidade uberlandia = cidades.get(0);
        Cidade saoPauloC = cidades.get(1);
        Cidade campinas = cidades.get(2);

        categoriaInformatica.getProdutos().addAll(produtos);
        categoriaEscritorio.getProdutos().add(impressora);

        computador.getCategorias().add(categoriaInformatica);
        impressora.getCategorias().addAll(Arrays.asList(categoriaInformatica, categoriaEscritorio));
        mouse.getCategorias().add(categoriaInformatica);

        minasGerais.getCidades().add(uberlandia);
        saoPaulo.getCidades().addAll(Arrays.asList(saoPauloC, campinas));

    }


}
