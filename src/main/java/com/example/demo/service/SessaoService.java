package com.example.demo.service;

import com.example.demo.model.Pauta;
import com.example.demo.model.Sessao;
import com.example.demo.repository.PautaRepository;
import com.example.demo.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessaoService {
    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private PautaRepository pautaRepository;

    public Sessao abrirSessao(Long pautaId, LocalDateTime fim) {
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new RuntimeException("Pauta não encontrada"));

        Sessao sessao = new Sessao();
        sessao.setPauta(pauta);
        sessao.setInicio(LocalDateTime.now());
        sessao.setFim(fim != null ? fim : LocalDateTime.now().plusMinutes(1));
        return sessaoRepository.save(sessao);
    }
}

