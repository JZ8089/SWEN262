package com.nutriapp;
public enum Goal {
    MAINTAIN_WEIGHT(0),
    LOSE_WEIGHT(1),
    GAIN_WEIGHT(2);

    private final int value;

    Goal(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
