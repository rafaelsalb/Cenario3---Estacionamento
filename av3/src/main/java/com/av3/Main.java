package com.av3;

import java.io.IOException;
import java.util.Scanner;

import de.gesundkrank.fzf4j.Fzf;
import de.gesundkrank.fzf4j.Fzf.AbortByUserException;
import de.gesundkrank.fzf4j.Fzf.EmptyResultException;
import de.gesundkrank.fzf4j.models.OrderBy;

public class Main {
    static Menu menu = new Menu();
    static Estacionamento estacionamento = new Estacionamento();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException, EmptyResultException, AbortByUserException {
        Fzf fzf = Fzf.builder()
                .orderBy(OrderBy.SCORE)
                .build();
    
        String placa;

        while (true) {
            switch (menu.select()) {
                case 1:
                    System.out.println("Digite a placa do carro");
                    System.out.print(">");
                    placa = sc.nextLine();
                    System.out.println("Digite a hora de entrada, depois, digite os minutos");
                    System.out.print("HORA >");
                    int hora = sc.nextInt();
                    System.out.print("MINUTO >");
                    int minuto = sc.nextInt();
                    estacionamento.push(placa, hora, minuto);
                    System.out.println("Registro criado.\n");
                    break;
                case 2:
                    placa = fzf.select(estacionamento.getPlacas());
                    RegistroEstacionamento r = estacionamento.remove(
                        estacionamento.search(placa)
                    );
                    System.out.println(r + " finalizado.");
                    break;
                case 3:
                    System.out.println(estacionamento.getRegistros());
                    break;
                default:
                    break;
            }
        }
    }
}