package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Acomodacao;
import com.example.demo.domain.Hospede;
import com.example.demo.domain.Reserva;
import com.example.demo.infra.exceptions.LimiteReservasExcedidoException;
import com.example.demo.repository.ReservaRepository;

import jakarta.transaction.Transactional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private AcomodacaoService acomodacaoService;

    @Autowired
    private HospedeService hospedeService;

    private static final int LIMITE_MAXIMO_RESERVAS = 3;

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Reserva obterReservaPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public List<Reserva> obterReservasPorHospede(Long hospedeId) {
        Hospede hospede = hospedeService.obterHospedePorId(hospedeId);
        return reservaRepository.findByHospede(hospede);
    }

    @Transactional
    public Reserva realizarReserva(Long acomodacaoId, Long hospedeId, LocalDate dataInicio, LocalDate dataFim) {
        Acomodacao acomodacao = acomodacaoService.obterAcomodacaoPorId(acomodacaoId);
        Hospede hospede = hospedeService.obterHospedePorId(hospedeId);

        if (hospede.atingiuLimiteReservasSimultaneas(LIMITE_MAXIMO_RESERVAS)) {
            throw new LimiteReservasExcedidoException("Limite máximo de reservas simultâneas atingido para o hóspede.");
        }

        Reserva reserva = new Reserva();
        reserva.setAcomodacao(acomodacao);
        reserva.setHospede(hospede);
        reserva.setDataInicio(dataInicio);
        reserva.setDataFim(dataFim);

        return reservaRepository.save(reserva);
    }
}
