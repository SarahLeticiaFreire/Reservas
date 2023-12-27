package com.example.demo.controller;

import com.example.demo.domain.Reserva;
import com.example.demo.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obterReservaPorId(@PathVariable Long id) {
        Reserva reserva = reservaService.obterReservaPorId(id);
        return ResponseEntity.ok(reserva);
    }

    @PostMapping
    public ResponseEntity<Reserva> realizarReserva(
            @RequestParam Long acomodacaoId,
            @RequestParam Long hospedeId,
            @RequestParam String dataInicio,
            @RequestParam String dataFim) {
        LocalDate dataInicioParsed = LocalDate.parse(dataInicio);
        LocalDate dataFimParsed = LocalDate.parse(dataFim);

        Reserva novaReserva = reservaService.realizarReserva(acomodacaoId, hospedeId, dataInicioParsed, dataFimParsed);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaReserva);
    }

    @GetMapping("/hospede/{hospedeId}")
    public List<Reserva> obterReservasPorHospede(@PathVariable Long hospedeId) {
        return reservaService.obterReservasPorHospede(hospedeId);
    }

}
