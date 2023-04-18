package com.nutriapp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class History {
    private List<Day> days;

    public History() {
        this.days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public List<Day> getDays() {
        return days;
    }

    public Day getDay(LocalDate date) {
        for (Day day : days) {
            if (day.getDate().equals(date)) {
                return day;
            }
        }
        return null;
    }
}
