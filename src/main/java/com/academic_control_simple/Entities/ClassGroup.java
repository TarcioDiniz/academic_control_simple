package com.academic_control_simple.Entities;

import com.academic_control_simple.Enums.Day;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClassGroup extends SchoolSchedule {

    private final UUID id;
    private final Discipline discipline;
    private final User teacher;
    private final List<User> students = new ArrayList<>();

    public ClassGroup(Discipline discipline, User teacher, Day day, LocalTime startTime, LocalTime endTime) {
        super(day, startTime, endTime);
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
