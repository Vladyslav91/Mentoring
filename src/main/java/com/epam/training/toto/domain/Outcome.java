package com.epam.training.toto.domain;

public enum Outcome {

    ONE("1"),
    TWO("2"),
    X("X");

    private final String value;

    private Outcome(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
