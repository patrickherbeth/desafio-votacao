package com.example.demo.controller;

import com.example.demo.model.Voto;
import com.example.demo.service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votos")
public class VotoController {
    @Autowired
    private VotoService votoService;

    @PostMapping("/registrar/{sessaoId}")
    public ResponseEntity<Voto> registrarVoto(@PathVariable Long sessaoId, @RequestParam String associadoId, @RequestParam boolean voto) {
        return ResponseEntity.ok(votoService.registrarVoto(sessaoId, associadoId, voto));
    }
}
