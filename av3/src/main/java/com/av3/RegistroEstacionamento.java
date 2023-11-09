package com.av3;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class RegistroEstacionamento {
    private LocalTime entrada;
    private LocalTime saida;
    private double custo;
    private String placa;

    public RegistroEstacionamento(String placa, int hour, int minute) {
        this.placa = placa;
        this.entrada = LocalTime.of(hour, minute, 0);
    }

    public double fechar(int hour, int minute) {
        this.saida = LocalTime.of(hour, minute, 0);
        this.custo = 3.0 * this.entrada.until(this.saida, ChronoUnit.MINUTES);
        return this.custo;
    }

    public LocalTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalTime entrada) {
        this.entrada = entrada;
    }

    public LocalTime getSaida() {
        return saida;
    }

    public void setSaida(LocalTime saida) {
        this.saida = saida;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return placa;
    }

}
