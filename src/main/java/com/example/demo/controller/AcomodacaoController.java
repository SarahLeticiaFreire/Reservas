package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.Acomodacao;
import com.example.demo.service.AcomodacaoService;

import java.util.List;

@RestController
@RequestMapping("/api/acomodacoes")
public class AcomodacaoController {

    @Autowired
    private AcomodacaoService acomodacaoService;

    @GetMapping
    public ResponseEntity<List<Acomodacao>> listarAcomodacoes() {
        List<Acomodacao> acomodacoes = acomodacaoService.listarAcomodacoes();
        return new ResponseEntity<>(acomodacoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acomodacao> obterAcomodacaoPorId(@PathVariable Long id) {
        Acomodacao acomodacao = acomodacaoService.obterAcomodacaoPorId(id);
        return new ResponseEntity<>(acomodacao, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Acomodacao> criarAcomodacao(@RequestBody Acomodacao acomodacao) {
        Acomodacao novaAcomodacao = acomodacaoService.criarAcomodacao(acomodacao);
        return new ResponseEntity<>(novaAcomodacao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acomodacao> atualizarAcomodacao(@PathVariable Long id, @RequestBody Acomodacao acomodacao) {
        Acomodacao acomodacaoAtualizada = acomodacaoService.atualizarAcomodacao(id, acomodacao);
        return new ResponseEntity<>(acomodacaoAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAcomodacao(@PathVariable Long id) {
        acomodacaoService.excluirAcomodacao(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
