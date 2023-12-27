package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Hospede;
import com.example.demo.repository.HospedeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    public Hospede obterHospedePorId(Long id) {
        Optional<Hospede> hospedeOptional = hospedeRepository.findById(id);
        return hospedeOptional.orElse(null);
    }

    public List<Hospede> listarHospedes() {
        return null;
    }

    public Hospede criarHospede(Hospede hospede) {
        return null;
    }

    public Hospede atualizarHospede(Long id, Hospede hospede) {
        return null;
    }

    public void excluirHospede(Long id) {
    }

}
