package com.academic_control_simple.model;

import java.time.LocalTime;

public class Horario {
    private final LocalTime horarioEntrada;
    private final LocalTime horarioSaida;

    public Horario(LocalTime entrada, LocalTime saida) {
        this.horarioEntrada = entrada;
        this.horarioSaida = saida;
    }

    public String getHorarioCompleto() {
        return horarioEntrada + " - " + horarioSaida;
    }
}