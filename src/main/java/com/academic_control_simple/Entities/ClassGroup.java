package com.academic_control_simple.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClassGroup {

    private final UUID id;
    private final Discipline discipline;
    private final User teacher;
    private final List<User> students = new ArrayList<>();

    public ClassGroup(Discipline discipline, User teacher) {
        this.discipline = discipline;
        this.teacher = teacher;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public User getTeacher() {
        return teacher;
    }

    public List<User> getStudents() {
        return students;
    }

    public void addStudent(User student) {
        students.add(student);
        student.getRDM().addDiscipline(discipline);
    }

}
