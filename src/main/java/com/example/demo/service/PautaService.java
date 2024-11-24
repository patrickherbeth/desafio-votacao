package com.example.demo.service;

import com.example.demo.model.Pauta;
import com.example.demo.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PautaService {
    @Autowired
    private PautaRepository pautaRepository;

    public Pauta criarPauta(Pauta pauta) {
        return pautaRepository.save(pauta);
    }
}

