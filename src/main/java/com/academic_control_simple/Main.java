package com.academic_control_simple;

import com.academic_control_simple.Entities.*;
import com.academic_control_simple.Enums.Rules;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        AcademicControl academicControl = new AcademicControl();

        User professor1 = academicControl.createUser("Sabrina de F. Souto", "senha123", Rules.TEACHER);
        User professor2 = academicControl.createUser("Carlos Eduardo", "senha123", Rules.TEACHER);
        User professor3 = academicControl.createUser("Joaquim Pedro", "senha123", Rules.TEACHER);

        User student1 = academicControl.createUser("Tarcio Diniz", "senha456", Rules.STUDENT);
        User student2 = academicControl.createUser("Clara Torres", "senha789", Rules.STUDENT);
        User student3 = academicControl.createUser("Ronaldo", "senha789", Rules.STUDENT);

        Discipline map = academicControl.createDiscipline("Metodos Avançados de Programação");
        Discipline dataStructures = academicControl.createDiscipline("Estruturas de Dados");
        Discipline operatingSystems = academicControl.createDiscipline("Sistemas Operacionais");
        Discipline computerNetworks = academicControl.createDiscipline("Redes de Computadores");

        ClassGroup classGroup1 = academicControl.createClassGroup(map.getId(), professor1.getId());
        ClassGroup classGroup2 = academicControl.createClassGroup(dataStructures.getId(), professor2.getId());
        ClassGroup classGroup3 = academicControl.createClassGroup(operatingSystems.getId(), professor3.getId());
        ClassGroup classGroup4 = academicControl.createClassGroup(computerNetworks.getId(), professor2.getId());

        classGroup1.addStudent(student1);
        classGroup1.addStudent(student2);
        classGroup1.addStudent(student3);
        classGroup2.addStudent(student1);

        System.out.println("Disciplinas cadastradas:");
        academicControl.getDisciplines().forEach(discipline -> System.out.println(discipline.getName()));

        System.out.println("\nTurmas cadastradas:");

        academicControl.getClassGroups().forEach(classGroup -> {
            System.out.println("Turma de " + classGroup.getDiscipline().getName() + " (Professor: " + classGroup.getTeacher().getFullName() + ")");
            String studentNames = classGroup.getStudents().stream()
                    .map(User::getFullName)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println("Alunos " + studentNames);
        });

        for (int i = 0; i < 5; i++) {
            SchoolTest test = new SchoolTest(BigDecimal.valueOf(Math.random() * 11).setScale(2, RoundingMode.HALF_UP));
            User user = academicControl.findUserByUserId(student1.getId());
            if (user.getRule() == Rules.STUDENT) {
                RDM rdm = user.getRDM();
                if (!rdm.getDisciplines().isEmpty()) {
                    rdm.getDiscipline(map.getId()).setSchoolTests(test);
                }
            }
        }

        System.out.println("\nDetalhes dos alunos:");

        academicControl.getUsers().forEach(user -> {
            if (user.getRule() == Rules.STUDENT) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

                    String jsonRdm = objectMapper.writeValueAsString(user);

                    System.out.println(user.getFullName() + ":" + jsonRdm + " \n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
