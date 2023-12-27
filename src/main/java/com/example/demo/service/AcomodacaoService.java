package com.example.demo.service;

import com.example.demo.domain.Acomodacao;
import com.example.demo.repository.AcomodacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcomodacaoService {

    @Autowired
    private AcomodacaoRepository acomodacaoRepository;

    public List<Acomodacao> listarAcomodacoes() {
        return acomodacaoRepository.findAll();
    }

    public Acomodacao obterAcomodacaoPorId(Long id) {
        Optional<Acomodacao> acomodacaoOptional = acomodacaoRepository.findById(id);
        return acomodacaoOptional.orElse(null);
    }

    public Acomodacao criarAcomodacao(Acomodacao acomodacao) {
        return acomodacaoRepository.save(acomodacao);
    }

    public Acomodacao atualizarAcomodacao(Long id, Acomodacao acomodacao) {
        return acomodacaoRepository.save(acomodacao);
    }

    public void excluirAcomodacao(Long id) {
        acomodacaoRepository.deleteById(id);
    }
}
