package com.example.demo.controller;

import com.example.demo.model.Sessao;
import com.example.demo.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {
    @Autowired
    private SessaoService sessaoService;

    @PostMapping("/abrir/{pautaId}")
    public ResponseEntity<Sessao> abrirSessao(@PathVariable Long pautaId, @RequestParam(required = false) LocalDateTime fim) {
        return ResponseEntity.ok(sessaoService.abrirSessao(pautaId, fim));
    }
}
