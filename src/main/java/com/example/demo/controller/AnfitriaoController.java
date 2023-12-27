package com.example.demo.controller;

import com.example.demo.domain.Anfitriao;
import com.example.demo.service.AnfitriaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anfitrioes")
public class AnfitriaoController {

    @Autowired
    private AnfitriaoService anfitriaoService;

    @GetMapping
    public List<Anfitriao> listarAnfitrioes() {
        return anfitriaoService.listarAnfitrioes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anfitriao> obterAnfitriaoPorId(@PathVariable Long id) {
        Anfitriao anfitriao = anfitriaoService.obterAnfitriaoPorId(id);
        return ResponseEntity.ok(anfitriao);
    }

    @PostMapping
    public ResponseEntity<Anfitriao> criarAnfitriao(@RequestBody Anfitriao anfitriao) {
        Anfitriao novoAnfitriao = anfitriaoService.criarAnfitriao(anfitriao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAnfitriao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Anfitriao> atualizarAnfitriao(@PathVariable Long id, @RequestBody Anfitriao anfitriao) {
        Anfitriao anfitriaoAtualizado = anfitriaoService.atualizarAnfitriao(id, anfitriao);
        return ResponseEntity.ok(anfitriaoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAnfitriao(@PathVariable Long id) {
        anfitriaoService.excluirAnfitriao(id);
        return ResponseEntity.noContent().build();
    }
}
