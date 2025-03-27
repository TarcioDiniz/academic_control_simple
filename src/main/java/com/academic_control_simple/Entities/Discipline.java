package com.academic_control_simple.Entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Discipline {

    private final UUID id;
    private String name;
    private final List<SchoolTest> schoolTests = new ArrayList<>();

    public Discipline(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public Discipline setName(String name) {
        this.name = name;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getMediaTests() {
        if (schoolTests == null || schoolTests.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal total = schoolTests.stream()
                .map(SchoolTest::getScore)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return total.divide(BigDecimal.valueOf(schoolTests.size()), 2, RoundingMode.HALF_UP);
    }

    public List<SchoolTest> getSchoolTests() {
        return schoolTests;
    }

    public List<SchoolTest> setSchoolTests(SchoolTest schoolTests) {
        this.schoolTests.add(schoolTests);
        return this.schoolTests;
    }

    public List<SchoolTest> removeSchoolTests(UUID id) {
        this.schoolTests.removeIf(schoolTest -> schoolTest.getId().equals(id));
        return this.schoolTests;
    }

}
