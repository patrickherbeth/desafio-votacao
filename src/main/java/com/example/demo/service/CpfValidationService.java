package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CpfValidationService {
    public boolean validarCPF(String cpf) {
        Random random = new Random();
        return random.nextBoolean();
    }
}
