package com.epam.training.toto.Enums;

public enum OutcomeEnum {

    ONE("1"),
    TWO("2"),
    X("X");

    private final String value;

    OutcomeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
