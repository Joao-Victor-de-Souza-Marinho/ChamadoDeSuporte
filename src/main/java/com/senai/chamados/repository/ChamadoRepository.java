package com.senai.chamados.repository;

import com.senai.chamados.domain.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChamadoRepository extends JpaRepository<Chamado, UUID> {

}