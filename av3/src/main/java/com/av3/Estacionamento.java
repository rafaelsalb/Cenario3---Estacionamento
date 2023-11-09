package com.av3;

import java.util.ArrayList;

public class Estacionamento {
    private ArrayList<RegistroEstacionamento> registros;

    Estacionamento() {
        registros = new ArrayList<>();
    }

    public void push(String placa, int hour, int minute) {
        registros.add(new RegistroEstacionamento(placa, hour, minute));
    }

    public RegistroEstacionamento remove(int idx) {
        RegistroEstacionamento r = registros.get(idx);
        registros.remove(idx);
        return r;
    }

    public int search(String placa) {
        for (int i = 0; i < registros.size(); i++) {
            if (placa.equalsIgnoreCase(registros.get(i).getPlaca())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Estacionamento [registros=" + registros + "]";
    }

    public ArrayList<String> getPlacas() {
        ArrayList<String> placas = new ArrayList<>();
        for (RegistroEstacionamento registro : registros) {
            placas.add(registro.getPlaca());
        }
        return placas;
    }

    public ArrayList<RegistroEstacionamento> getRegistros() {
        return registros;
    }

    public void setRegistros(ArrayList<RegistroEstacionamento> registros) {
        this.registros = registros;
    }
}
