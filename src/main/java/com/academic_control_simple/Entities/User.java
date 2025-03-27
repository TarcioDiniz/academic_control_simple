package com.academic_control_simple.Entities;

import com.academic_control_simple.Enums.Rules;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String fullName;
    private final String password;
    private final Rules rule;
    private final RDM rdm;

    public User(UUID matricula, String fullName, String password, Rules rule) {
        this.id = matricula;
        this.fullName = fullName;
        this.password = password;
        this.rule = rule;
        this.rdm = new RDM();
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public Rules getRule() {
        return rule;
    }

    public RDM getRDM() {
        return rdm;
    }
}
