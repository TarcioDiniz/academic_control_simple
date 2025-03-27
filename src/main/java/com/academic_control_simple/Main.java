package com.academic_control_simple;

import com.academic_control_simple.Entities.*;
import com.academic_control_simple.Enums.Day;
import com.academic_control_simple.Enums.Rules;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        AcademicControl academicControl = new AcademicControl();

        // Criando professores
        User professor1 = academicControl.createUser("Sabrina de F. Souto", "senha123", Rules.TEACHER);
        User professor2 = academicControl.createUser("Carlos Eduardo", "senha123", Rules.TEACHER);
        User professor3 = academicControl.createUser("Joaquim Pedro", "senha123", Rules.TEACHER);

        // Criando estudantes
        User student1 = academicControl.createUser("Tarcio Diniz", "senha456", Rules.STUDENT);
        User student2 = academicControl.createUser("Clara Torres", "senha789", Rules.STUDENT);
        User student3 = academicControl.createUser("Ronaldo", "senha789", Rules.STUDENT);

        // Criando disciplinas
        Discipline map = academicControl.createDiscipline("Metodos Avançados de Programação");
        Discipline dataStructures = academicControl.createDiscipline("Estruturas de Dados");
        Discipline operatingSystems = academicControl.createDiscipline("Sistemas Operacionais");
        Discipline computerNetworks = academicControl.createDiscipline("Redes de Computadores");

        // Criando turmas
        ClassGroup classGroup1 = academicControl.createClassGroup(map.getId(), professor1.getId(), Day.MONDAY, LocalTime.of(8, 0));
        ClassGroup classGroup2 = academicControl.createClassGroup(dataStructures.getId(), professor2.getId(), Day.TUESDAY, LocalTime.of(10, 0));
        ClassGroup classGroup3 = academicControl.createClassGroup(operatingSystems.getId(), professor3.getId(), Day.WEDNESDAY, LocalTime.of(13, 0));
        ClassGroup classGroup4 = academicControl.createClassGroup(computerNetworks.getId(), professor2.getId(), Day.THURSDAY, LocalTime.of(15, 0));

        // Adicionando estudantes às turmas
        classGroup1.addStudent(student1);
        classGroup1.addStudent(student2);
        classGroup1.addStudent(student3);
        classGroup2.addStudent(student1);

        // Exibição das disciplinas cadastradas
        System.out.println("\n=== Disciplinas Cadastradas ===");
        academicControl.getDisciplines().forEach(discipline -> System.out.println("- " + discipline.getName()));

        // Exibição das turmas cadastradas
        System.out.println("\n=== Turmas Cadastradas ===");
        academicControl.getClassGroups().forEach(classGroup -> {
            System.out.println("Turma de " + classGroup.getDiscipline().getName() + " (Professor: " + classGroup.getTeacher().getFullName() + ")");
            String studentNames = classGroup.getStudents().stream()
                    .map(User::getFullName)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println("Alunos: " + studentNames);
        });

        // Geração de notas para um aluno
        for (int i = 0; i < 5; i++) {
            SchoolTest test = new SchoolTest(BigDecimal.valueOf(Math.random() * 11).setScale(2, RoundingMode.HALF_UP));
            student1.getRDM().getDiscipline(map.getId()).setSchoolTests(test);
        }

        // Exibição detalhada das informações solicitadas
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            System.out.println("\n=== Informações Detalhadas ===");

            // (a) Disciplinas ministradas por cada professor
            System.out.println("\n(a) Disciplinas ministradas por cada professor:");
            academicControl.getUsers().stream().filter(u -> u.getRule() == Rules.TEACHER).forEach(teacher -> {
                List<String> disciplines = academicControl.getClassGroups().stream()
                        .filter(cg -> cg.getTeacher().getId().equals(teacher.getId()))
                        .map(cg -> cg.getDiscipline().getName())
                        .collect(Collectors.toList());
                System.out.println(teacher.getFullName() + " -> " + disciplines);
            });

            // (b) Horário de cada professor
            System.out.println("\n(b) Horário de cada professor:");
            List<ClassGroup> classGroups = academicControl.getClassGroups();

            // Agrupando por professor
            Map<String, List<String>> teacherSchedule = classGroups.stream()
                    .collect(Collectors.groupingBy(
                            classGroup -> classGroup.getTeacher().getFullName(),  // Agrupar pelo nome do professor
                            Collectors.mapping(classGroup ->
                                            "Disciplina: " + classGroup.getDiscipline().getName() +
                                                    " | Dia: " + classGroup.getDay() +
                                                    " | Horário: " + classGroup.getStartTime() + " - " + classGroup.getEndTime(),
                                    Collectors.toList())
                    ));

            // Imprimindo os horários dos professores
            teacherSchedule.forEach((teacherName, scheduleInfo) -> {
                System.out.println("Professor: " + teacherName);
                scheduleInfo.forEach(System.out::println);
            });

            // (c) Alunos de cada disciplina
            System.out.println("\n(c) Alunos de cada disciplina:");
            academicControl.getClassGroups().forEach(classGroup -> {
                System.out.println(classGroup.getDiscipline().getName() + " -> " + classGroup.getStudents().stream().map(User::getFullName).collect(Collectors.toList()));
            });

            // (d) Disciplinas de cada aluno
            System.out.println("\n(d) Disciplinas de cada aluno:");
            academicControl.getUsers().stream().filter(u -> u.getRule() == Rules.STUDENT).forEach(student -> {
                System.out.println(student.getFullName() + " -> " + student.getRDM().getDisciplines().stream().map(Discipline::getName).collect(Collectors.toList()));
            });

            // (e) Horário de cada aluno
            System.out.println("\n(e) Horário de cada aluno:");

            // Agrupando por aluno
            Map<String, List<String>> studentsClasses = classGroups.stream()
                    .flatMap(classGroup -> classGroup.getStudents().stream()
                            .map(student -> new AbstractMap.SimpleEntry<>(student, classGroup)))
                    .collect(Collectors.groupingBy(
                            entry -> entry.getKey().getFullName(),
                            Collectors.mapping(entry ->
                                            "Disciplina: " + entry.getValue().getDiscipline().getName() +
                                                    " | Professor: " + entry.getValue().getTeacher().getFullName() +
                                                    " | Dia: " + entry.getValue().getDay() +
                                                    " | Horário: " + entry.getValue().getStartTime() + " - " + entry.getValue().getEndTime(),
                                    Collectors.toList())
                    ));

            // Imprimindo as informações agrupadas
            studentsClasses.forEach((studentName, classInfo) -> {
                System.out.println("Aluno: " + studentName);
                classInfo.forEach(System.out::println);
                System.out.println();
            });

            // (f) Número de alunos em cada disciplina
            System.out.println("\n(f) Número de alunos em cada disciplina:");
            academicControl.getClassGroups().forEach(classGroup -> {
                System.out.println(classGroup.getDiscipline().getName() + " -> " + classGroup.getStudents().size() + " alunos");
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
