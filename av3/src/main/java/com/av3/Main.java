package com.av3;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    static Menu menu = new Menu();
    static Estacionamento estacionamento = new Estacionamento(5, 4);
    static Scanner sc = new Scanner(System.in);

    public static int nextInt() {
        int res;
        try {
            res = sc.nextInt();
        }
        finally {
            sc.nextLine();
        }
        return res;
    }

    public static void main(String[] args) {
        TaxasEstacionamento.setTaxaInicial(6.00);
        TaxasEstacionamento.setTaxaAdicional(2.00);
        String placa;
        int hora, minuto, x, y;

        while (true) {
            switch (menu.select()) {
                case 1:
                    System.out.println("Digite a placa do carro");
                    System.out.print(">");
                    placa = sc.nextLine();
                    while (placa.length() != 7) {
                        System.out.println("A placa informada não está no formato correto. Tente novamente.");
                        System.out.print(">");
                        placa = sc.nextLine();
                    }
                    System.out.println("Digite a hora de entrada, depois, digite os minutos");
                    System.out.print("HORA >");
                    hora = sc.nextInt();
                    sc.nextLine();
                    System.out.print("MINUTO >");
                    minuto = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Posição X >");
                    x = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Posição Y >");
                    y = sc.nextInt();
                    sc.nextLine();
                    try {estacionamento.iniciarEstadia(placa, hora, minuto, x, y);}
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    System.out.println("Registro criado.\n");
                    break;
                case 2:
                    System.out.println(estacionamento.visualize());
                    System.out.println("Digite a posição do carro cuja estadia deseja finalizar.");
                    try {
                        System.out.print("X >");
                        x = nextInt();
                        System.out.print("Y >");
                        y = nextInt();
                        System.out.println("Digite a hora de saída, depois, digite os minutos");
                        System.out.print("HORA >");
                        hora = nextInt();
                        System.out.print("MINUTO >");
                        minuto = nextInt();
                        RegistroEstacionamento r = estacionamento.finalizarEstadia(
                            hora,
                            minuto,
                            x,
                            y
                        );
                        System.out.println();
                        System.out.println(r + " finalizado.");
                        System.out.print("Horário de entrada: ");
                        System.out.println(r.getEntrada().toString());
                        System.out.print("Horário de saída: ");
                        System.out.println(r.getSaida().toString());
                        System.out.print("Duração da estadia: ");
                        System.out.println(LocalTime.ofSecondOfDay(r.getEntrada().until(r.getSaida(), ChronoUnit.SECONDS)));
                        System.out.println(
                            String.format("Custo da estadia: R$%.2f\n", r.getCusto())
                        );
                    }
                    catch (Exception e) {
                        System.out.println("Não foi possível finalizar a estadia:");
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(estacionamento.visualize());
                    break;
            }
        }
    }
}