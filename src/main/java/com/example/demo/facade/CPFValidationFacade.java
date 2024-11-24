package com.example.demo.facade;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CPFValidationFacade {

    // Simula uma validação aleatória de CPF
    public String validateCPF(String cpf) {
        if (!isValidFormat(cpf)) {
            throw new IllegalArgumentException("Formato de CPF inválido");
        }

        Random random = new Random();
        boolean isValid = random.nextBoolean();

        if (!isValid) {
            return "UNABLE_TO_VOTE";
        }
        return "ABLE_TO_VOTE";
    }

    // Método para verificar o formato do CPF (pode ser expandido com validações específicas)
    private boolean isValidFormat(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }
}

