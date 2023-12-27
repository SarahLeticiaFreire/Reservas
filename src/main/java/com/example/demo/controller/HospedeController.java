package com.example.demo.controller;

import com.example.demo.domain.Hospede;
import com.example.demo.service.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

    @Autowired
    private HospedeService hospedeService;

    @GetMapping
    public List<Hospede> listarHospedes() {
        return hospedeService.listarHospedes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> obterHospedePorId(@PathVariable Long id) {
        Hospede hospede = hospedeService.obterHospedePorId(id);
        return ResponseEntity.ok(hospede);
    }

    @PostMapping
    public ResponseEntity<Hospede> criarHospede(@RequestBody Hospede hospede) {
        Hospede novoHospede = hospedeService.criarHospede(hospede);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoHospede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospede> atualizarHospede(@PathVariable Long id, @RequestBody Hospede hospede) {
        Hospede hospedeAtualizado = hospedeService.atualizarHospede(id, hospede);
        return ResponseEntity.ok(hospedeAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirHospede(@PathVariable Long id) {
        hospedeService.excluirHospede(id);
        return ResponseEntity.noContent().build();
    }
}
