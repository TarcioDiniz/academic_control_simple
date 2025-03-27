package com.academic_control_simple.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RDM {
    private final List<Discipline> disciplines = new ArrayList<>();

    public void addDiscipline(Discipline discipline) {
        disciplines.add(discipline);
    }

    private List<Discipline> removeDiscipline(UUID id) {
        disciplines.removeIf(discipline -> discipline.getId().equals(id));
        return disciplines;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public Discipline getDiscipline(UUID id) {
        return disciplines.stream().filter(discipline -> discipline.getId().equals(id)).findFirst().orElse(null);
    }
}
