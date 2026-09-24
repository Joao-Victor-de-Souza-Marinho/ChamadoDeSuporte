package com.senai.chamados.domain.entity;

import com.senai.chamados.domain.enums.StatusChamado;
import com.senai.chamados.domain.enums.UrgenciaChamado;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    private String solicitante;
    private String dispositivo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private UrgenciaChamado urgencia;

    @Enumerated(EnumType.STRING)
    private StatusChamado status;

    private LocalDateTime dataAbertura;

    public Chamado(){}

    public Chamado(String solicitante, String dispositivo, String descricao) {
        this.solicitante = solicitante;
        this.dispositivo = dispositivo;
        this.descricao = descricao;
        this.status = StatusChamado.ABERTO;
        this.urgencia = UrgenciaChamado.NAO_CLASSIFICADA;
        this.dataAbertura = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public UrgenciaChamado getUrgencia() {
        return urgencia;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }


}
