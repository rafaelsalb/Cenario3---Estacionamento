package com.av3;

import java.util.Scanner;

public class Main {
    static Menu menu = new Menu();
    static Estacionamento estacionamento = new Estacionamento(10, 10);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TaxasEstacionamento.getInstance(6.00, 2.0);
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
                    estacionamento.iniciarEstadia(placa, hora, minuto, x, y);
                    System.out.println("Registro criado.\n");
                    break;
                case 2:
                    System.out.println(estacionamento.visualize());
                    System.out.println("Digite a posição do carro cuja estadia deseja finalizar.");
                    System.out.print("X >");
                    x = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Y >");
                    y = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite a hora de saída, depois, digite os minutos");
                    System.out.print("HORA >");
                    hora = sc.nextInt();
                    sc.nextLine();
                    System.out.print("MINUTO >");
                    minuto = sc.nextInt();
                    sc.nextLine();
                    RegistroEstacionamento r = estacionamento.finalizarEstadia(
                        hora,
                        minuto,
                        x,
                        y
                    );
                    System.out.println(r + " finalizado.");
                    System.out.println(
                        String.format("Custo da estadia: R$%.2f\n", r.getCusto())
                    );
                    break;
                case 3:
                    // System.out.println(estacionamento.getRegistros());
                    System.out.println(estacionamento.visualize());
                    break;
                default:
                    break;
            }
        }
    }
}