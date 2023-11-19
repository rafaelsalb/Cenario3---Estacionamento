package com.av3;

import java.util.ArrayList;

public class Estacionamento {
    private RegistroEstacionamento[][] registros;
    private ArrayList<RegistroEstacionamento> historico;

    Estacionamento(int m, int n) {
        registros = new RegistroEstacionamento[m][n];
        historico = new ArrayList<>();
    }

    public void iniciarEstadia(String placa, int hour, int minute, int x, int y) throws Exception {
        if (registros[x][y] != null) {
            throw new Exception("A posícão " + x + " " + y + " já está ocupada.");
        }
        RegistroEstacionamento r = new RegistroEstacionamento(placa.toUpperCase(), hour, minute);
        System.out.println("A placa informada é do estado " + r.getPlaca().getEstado());
        registros[y][x] = r;
    }

    public RegistroEstacionamento finalizarEstadia(int hora, int minuto, int x, int y) {
        RegistroEstacionamento r = registros[x][y];
        registros[x][y] = null;
        r.fechar(hora, minuto);
        historico.add(r);
        return r;
    }

    public int[] search(String placa) {
        for (int i = 0; i < registros.length; i++) {
            for (int j = 0; j < registros[0].length; j++) {
                if (placa.equalsIgnoreCase(registros[i][j].getPlacaString())) {
                    int[] res = {i, j};
                    return res;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Estacionamento [registros=" + registros + "]";
    }

    public ArrayList<String> getPlacas() {
        ArrayList<String> placas = new ArrayList<>();
        for (RegistroEstacionamento[] registroLinha : registros) {
            for (RegistroEstacionamento registro : registroLinha) {
                if (registro != null)
                    placas.add(registro.getPlacaString());
            }
        }
        return placas;
    }

    public RegistroEstacionamento[][] getRegistros() {
        return registros;
    }

    public void setRegistros(RegistroEstacionamento[][] registros) {
        this.registros = registros;
    }

    public String visualize() {
        StringBuilder res = new StringBuilder();
        res.append("   ");
        for (int i = 0; i < registros[0].length; i++) {
            res.append(i);
            for (int j = String.valueOf(i).length(); j < 7; j++) {
                res.append("_");
            }
            res.append(" ");
        }
        res.append("\n");
        for (int i = 0; i < registros.length; i++) {
            res.append(String.valueOf(i) + "| ");
            for (int j = 0; j < registros[0].length; j++) {
                res.append(registros[i][j] == null ? "-------" : registros[i][j].getPlacaString());
                res.append(" ");
            }
            res.append("\n");
        }
        return res.toString();
    }
}
