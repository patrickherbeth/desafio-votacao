package com.example.demo.controller;

import com.example.demo.service.CPFValidationService;
import com.example.demo.service.CpfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cpf")
public class CpfController {

    @Autowired
    private CpfService cpfService;

    @Autowired
    private CPFValidationService cpfValidationService;


    @GetMapping("/gerar")
    public ResponseEntity<String> gerarCpf() {
        String cpf = cpfService.gerarCpfAleatorio();
        return ResponseEntity.ok(cpf);
    }

    @GetMapping("/validate/{cpf}")
    public ResponseEntity<String> validateCPF(@PathVariable String cpf) {
        String result = cpfValidationService.verifyCPF(cpf);
        return ResponseEntity.ok("{\"status\": \"" + result + "\"}");
    }
}
