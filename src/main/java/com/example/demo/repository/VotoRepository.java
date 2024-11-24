package com.example.demo.repository;

import com.example.demo.model.Sessao;
import com.example.demo.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
    boolean existsByAssociadoIdAndSessao(String associadoId, Sessao sessao);
}
