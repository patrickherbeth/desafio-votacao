package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CpfService {

    public String gerarCpfAleatorio() {
        Random random = new Random();
        int[] cpf = new int[9];

        // Gerando os 9 primeiros dígitos aleatórios
        for (int i = 0; i < 9; i++) {
            cpf[i] = random.nextInt(10);
        }

        // Calculando os dígitos verificadores
        cpf = calcularDigitosVerificadores(cpf);

        // Formatando CPF
        return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d",
                cpf[0], cpf[1], cpf[2],
                cpf[3], cpf[4], cpf[5],
                cpf[6], cpf[7], cpf[8],
                cpf[9], cpf[10]);
    }

    private int[] calcularDigitosVerificadores(int[] cpf) {
        int[] completo = new int[11];
        System.arraycopy(cpf, 0, completo, 0, 9);

        // Primeiro dígito verificador
        completo[9] = calcularDigito(cpf, 10);

        // Segundo dígito verificador
        completo[10] = calcularDigito(completo, 11);

        return completo;
    }

    private int calcularDigito(int[] cpf, int pesoInicial) {
        int soma = 0;
        for (int i = 0; i < pesoInicial - 1; i++) {
            soma += cpf[i] * (pesoInicial - i);
        }
        int resto = soma % 11;
        return resto < 2 ? 0 : 11 - resto;
    }
}
