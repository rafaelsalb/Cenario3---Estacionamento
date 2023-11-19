package com.av3;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class RegistroEstacionamento {
    private LocalTime entrada;
    private LocalTime saida;
    private Placa placa;
    private double custo;

    public RegistroEstacionamento(String placa, int hour, int minute) {
        this.placa = new Placa(placa);
        this.entrada = LocalTime.of(hour, minute, 0);
    }

    public double fechar(int hour, int minute) {
        this.saida = LocalTime.of(hour, minute, 0);
        long time_diff = this.entrada.until(this.saida, ChronoUnit.MINUTES);
        double custoInicial = TaxasEstacionamento.getTaxaInicial();
        if (time_diff <= 15) {
            this.custo = 0;
        }
        else if (time_diff <= 180) {
            this.custo = custoInicial;
        }
        else {
            long duracaoEstadia = this.entrada.until(this.saida, ChronoUnit.MINUTES);
            long minutosAdicionais = duracaoEstadia - 180;
            double custoAdicional = Math.ceil((minutosAdicionais / 60.0)) * TaxasEstacionamento.getTaxaAdicional();
            this.custo = custoInicial + custoAdicional;
        }
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

    public String getPlacaString() {
        return placa.getPlacaString();
    }

    public Placa getPlaca() {
        return placa;
    }

    public void setPlaca(Placa placa) {
        this.placa = placa;
    }
    
    @Override
    public String toString() {
        return placa.getPlacaString();
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

}
