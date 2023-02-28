package com.nutriapp;
import java.time.LocalDateTime;

public class Workout {
    private int duration; // in minutes
    private int intensity; // measured in METs (metabolic equivalents)
    private LocalDateTime dateTime;

    public Workout(int duration, int intensity, LocalDateTime dateTime) {
        this.duration = duration;
        this.intensity = intensity;
        this.dateTime = dateTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getIntensity() {
        return intensity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "duration=" + duration +
                ", intensity=" + intensity +
                ", dateTime=" + dateTime +
                '}';
    }
}