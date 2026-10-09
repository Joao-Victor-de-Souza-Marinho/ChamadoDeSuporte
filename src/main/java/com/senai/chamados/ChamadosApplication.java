package com.senai.chamados;

import com.senai.chamados.domain.entity.Chamado;
import com.senai.chamados.service.ChamadoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class ChamadosApplication implements CommandLineRunner {
    private final ChamadoService chamadoService;

    public ChamadosApplication(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ChamadosApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        Chamado chamado = new Chamado("João Victor", "Computador", "Sem Imagem");
        chamadoService.criar(chamado);
        System.out.println(chamado);
         List<Chamado> chamados = chamadoService.buscarTodos();
        for (Chamado lista:chamados){
            System.out.println(lista.getId());
            System.out.println(lista.getStatus());
            System.out.println(lista.getSolicitante());
        }

        Chamado inexistente = chamadoService.buscarPorId(UUID.randomUUID());

        System.out.println(inexistente.getSolicitante());
        System.out.println(chamado.getDispositivo());
    }
}
