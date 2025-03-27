package com.academic_control_simple.Entities;

import com.academic_control_simple.Enums.Day;
import com.academic_control_simple.Enums.Rules;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AcademicControl {

    private final List<User> users = new ArrayList<>();
    private final List<ClassGroup> classGroups = new ArrayList<>();
    private final List<Discipline> disciplines = new ArrayList<>();

    public User createUser(
            String fullName,
            String password,
            Rules rule
    ) {
        User user = new User(UUID.randomUUID(), fullName, password, rule);
        users.add(user);
        return user;
    }

    public User findUserByUserId(UUID userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }


    public Discipline createDiscipline(String name) {
        Discipline discipline = new Discipline(name);
        disciplines.add(discipline);
        return discipline;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public Discipline findDisciplineById(UUID id) {
        for (Discipline discipline : disciplines) {
            if (discipline.getId().equals(id)) {
                return discipline;
            }
        }
        return null;
    }

    public ClassGroup createClassGroup(UUID disciplineId, UUID userId, Day day, LocalTime startTime) {
        Discipline discipline = findDisciplineById(disciplineId);
        User user = findUserByUserId(userId);

        if (user.getRule() == Rules.TEACHER) {
            LocalTime endTime = startTime.plusHours(2);
            ClassGroup classGroup = new ClassGroup(discipline, user, day, startTime, endTime);
            classGroups.add(classGroup);
            return classGroup;
        }

        return null;
    }

    public List<ClassGroup> getClassGroups() {
        return classGroups;
    }


    public List<User> getUsers() {
        return users;
    }
}
