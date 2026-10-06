package com.cantina.produtos.controller;

import com.cantina.produtos.model.Produto;
import com.cantina.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Listar produtos
    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll());
        model.addAttribute("produto", new Produto());
        return "produtos";
    }

    // Guardar novo produto
    @PostMapping("/guardar")
    public String guardarProduto(@ModelAttribute Produto produto) {
        produto.setDataCadastro(LocalDate.now()); // Preenche a data de registo automaticamente
        produtoRepository.save(produto);
        return "redirect:/produtos";
    }
}