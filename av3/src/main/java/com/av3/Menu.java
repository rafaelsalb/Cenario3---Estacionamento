package com.av3;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public ArrayList<String> opcoes;
    private Scanner sc;

    Menu() {
        this.opcoes = new ArrayList<>();
        opcoes.add("[1] Adicionar novo registro");
        opcoes.add("[2] Finalizar estadia");
        opcoes.add("[3] Visualizar carros estacionados");
        sc = new Scanner(System.in);
    }

    public int select() {
        for (String opcao : opcoes) {
            System.out.println(opcao);
        }
        System.out.print(">");
        return sc.nextInt();
    }
}
