package com.senai.chamados.teste;

import com.senai.chamados.domain.entity.Chamado;

public class TesteChamado {

    public static void main(String[] args) {

        Chamado c1 = new Chamado("João Victor", "Computador","Erro ao iniciar, não dá video");

        boolean r1 = c1.resolver();
        boolean r2 = c1.iniciarAtendimento();
        boolean r3 = c1.resolver();

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);






    }
}
