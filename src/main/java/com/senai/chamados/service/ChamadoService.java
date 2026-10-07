package com.senai.chamados.service;

import com.senai.chamados.domain.entity.Chamado;
import com.senai.chamados.repository.ChamadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository) {
        this.chamadoRepository = chamadoRepository;
    }

    public Chamado criar(Chamado chamado) {
        chamadoRepository.save(chamado);
        return chamado;
    }
    public List<Chamado> buscarTodos(){
        return chamadoRepository.findAll();

    }
}