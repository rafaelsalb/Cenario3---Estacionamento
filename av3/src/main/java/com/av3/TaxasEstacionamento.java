package com.av3;

public final class TaxasEstacionamento {
    private static TaxasEstacionamento instance;
    private static double taxaInicial;
    private static double taxaAdicional;

    private TaxasEstacionamento(double taxaInicial, double taxaAdicional) {
        TaxasEstacionamento.taxaInicial = taxaInicial;
        TaxasEstacionamento.taxaAdicional = taxaAdicional;
    }

    public static TaxasEstacionamento getInstance(double taxaInicial, double taxaAdicional) {
        if (instance == null) {
            instance = new TaxasEstacionamento(taxaInicial, taxaAdicional);
        }
        return instance;
    }

    public static double getTaxaInicial() {
        return taxaInicial;
    }

    public static void setTaxaInicial(double taxaInicial) {
        TaxasEstacionamento.taxaInicial = taxaInicial;
    }

    public static double getTaxaAdicional() {
        return taxaAdicional;
    }

    public static void setTaxaAdicional(double taxaAdicional) {
        TaxasEstacionamento.taxaAdicional = taxaAdicional;
    }
}