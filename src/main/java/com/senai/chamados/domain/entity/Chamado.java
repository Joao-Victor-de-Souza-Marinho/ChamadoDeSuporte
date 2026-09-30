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
        if (solicitante == null || solicitante.isBlank() ){
            throw new IllegalArgumentException("O campo do solicitante não pode ser vazio");
        }
        if (descricao == null || descricao.isBlank()){
            throw new IllegalArgumentException("O campo de descrição não pode ser vazio");
        }
        if (dispositivo == null || dispositivo.isBlank() ){
            throw new IllegalArgumentException("O campo de dispositivo não pode ser vazio");
        }
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

    public boolean iniciarAtendimento() {
        if (status == StatusChamado.ABERTO) {
            this.status = StatusChamado.EM_ATENDIMENTO;
            return true;
        }
        return false;
    }

    public boolean resolver() {
        if (status == StatusChamado.EM_ATENDIMENTO) {
            this.status = StatusChamado.RESOLVIDO;
            return true;
        }
        return false;
    }

    public boolean classificarUrgencia(UrgenciaChamado urgencia) {
        if (urgencia != null
                && status == StatusChamado.ABERTO
                && urgencia != UrgenciaChamado.NAO_CLASSIFICADA) {
            this.urgencia = urgencia;
            return true;
        }
        return false;
    }

}
