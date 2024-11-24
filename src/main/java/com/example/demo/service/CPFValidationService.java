package com.example.demo.service;

import com.example.demo.facade.CPFValidationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CPFValidationService {

    @Autowired
    private CPFValidationFacade cpfValidationFacade;

    public String verifyCPF(String cpf) {
        try {
            String validationResult = cpfValidationFacade.validateCPF(cpf);

            if ("UNABLE_TO_VOTE".equals(validationResult)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CPF não apto para votar");
            }

            return validationResult;

        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
