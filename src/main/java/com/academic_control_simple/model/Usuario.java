package com.academic_control_simple.model;

public abstract class Usuario {
    protected String matricula;
    protected String nome;
    protected String email;
    protected String senha;
    protected Horario horario;

    public Usuario(String matricula, String nome, String email, String senha, Horario horario) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public Horario getHorario() {
        return horario;
    }
}