package com.academic_control_simple.model;

public abstract class Usuario {
    protected String matricula;
    protected String nome;
    protected Horario horario;

    public Usuario(String matricula, String nome, Horario horario) {
        this.matricula = matricula;
        this.nome = nome;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public Horario getHorario() {
        return horario;
    }

    public String getMatricula() {
        return matricula;
    }
}