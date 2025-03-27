package com.academic_control_simple.Entities;

import com.academic_control_simple.Enums.Day;

import java.time.LocalTime;

public class SchoolSchedule {

    private final Day day;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public SchoolSchedule(Day day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Day getDay() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

}
