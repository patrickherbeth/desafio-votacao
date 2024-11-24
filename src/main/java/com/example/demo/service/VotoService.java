package com.example.demo.service;

import com.example.demo.model.Sessao;
import com.example.demo.model.Voto;
import com.example.demo.repository.SessaoRepository;
import com.example.demo.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {
    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private SessaoRepository sessaoRepository;

    public Voto registrarVoto(Long sessaoId, String associadoId, boolean voto) {
        Sessao sessao = sessaoRepository.findById(sessaoId)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));

        if (votoRepository.existsByAssociadoIdAndSessao(associadoId, sessao)) {
            throw new RuntimeException("Associado já votou nesta sessão");
        }

        Voto novoVoto = new Voto();
        novoVoto.setAssociadoId(associadoId);
        novoVoto.setVoto(voto);
        novoVoto.setSessao(sessao);
        return votoRepository.save(novoVoto);
    }
}

