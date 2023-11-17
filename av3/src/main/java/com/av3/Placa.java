package com.av3;

public class Placa {
    private String placa;
    private String estado;

    public Placa(String placa) {
        this.placa = placa.toUpperCase();
        this.estado = placaParaEstado(placa);
    }

    private String placaParaEstado(String placa) {
        int p = placaInt(placa);
        if (p >= placaInt("MZN") && p <= placaInt("NAG")) return "AC";
        else if (p >= placaInt("JWF") && p <= placaInt("JXY")) return "AM";
        else if (p >= placaInt("NBB") && p <= placaInt("NEH")) return "RO";
        return "??";
    }

    private int placaInt(String placa) {
        char[] chars = placa.toCharArray();
        return ((int)chars[0] - 65) * 100 + ((int)chars[1] - 65) * 10 + ((int)chars[2] - 65);
    }

    public String getPlacaString() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
