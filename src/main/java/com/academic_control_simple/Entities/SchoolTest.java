package com.academic_control_simple.Entities;

import java.math.BigDecimal;
import java.util.UUID;

public class SchoolTest {

    private final UUID id;
    private final BigDecimal score;

    public SchoolTest(BigDecimal score) {
        this.score = score;
        this.id = UUID.randomUUID();
    }

    public BigDecimal getScore() {
        return score;
    }

    public UUID getId() {
        return id;
    }

}
