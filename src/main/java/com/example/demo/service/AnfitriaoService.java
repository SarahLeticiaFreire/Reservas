package com.example.demo.service;

import com.example.demo.domain.Anfitriao;
import com.example.demo.infra.exceptions.AnfitriaoNotFoundException;
import com.example.demo.repository.AnfitriaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AnfitriaoService {

    @Autowired
    private AnfitriaoRepository anfitriaoRepository;

    public List<Anfitriao> listarAnfitrioes() {
        return anfitriaoRepository.findAll();
    }

    public Anfitriao obterAnfitriaoPorId(Long id) {
        Optional<Anfitriao> anfitriaoOptional = anfitriaoRepository.findById(id);
        return anfitriaoOptional.orElseThrow(() -> {
            throw new AnfitriaoNotFoundException("Anfitrião não encontrado com o ID: " + id);
        });
    
    }

    public Anfitriao criarAnfitriao(Anfitriao anfitriao) {
        validarCamposObrigatorios(anfitriao);

        // Garante que o anfitrião a ser criado não tenha um ID especificado
        if (Objects.isNull(anfitriao.getId())) {
            return anfitriaoRepository.save(anfitriao);
        } else {
            // Trate a situação em que um ID foi especificado para um novo anfitrião.
            throw new IllegalArgumentException("O ID não deve ser especificado ao criar um novo anfitrião.");
        }
    }

    public Anfitriao atualizarAnfitriao(Long id, Anfitriao anfitriao) {
        validarCamposObrigatorios(anfitriao);

        // Verifica se o anfitrião existe antes de tentar atualizar
        if (anfitriaoRepository.existsById(id)) {
            anfitriao.setId(id);
            return anfitriaoRepository.save(anfitriao);
        } else {
            // Trate a situação em que o anfitrião com o ID especificado não foi encontrado.
            throw new AnfitriaoNotFoundException("Anfitrião não encontrado com o ID: " + id);
        }
    }

    public void excluirAnfitriao(Long id) {
        if (anfitriaoRepository.existsById(id)) {
            anfitriaoRepository.deleteById(id);
        } else {
            throw new AnfitriaoNotFoundException("Anfitrião não encontrado com o ID: " + id);
        }
    }

    private void validarCamposObrigatorios(Anfitriao anfitriao) {
        // Adicione validações adicionais conforme necessário
        if (Objects.isNull(anfitriao.getNome()) || anfitriao.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome do anfitrião é obrigatório.");
        }
    }
}
