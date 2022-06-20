package com.example.csvviewer1.model;

public enum Option {

    FIRST_PAGE("F"),
    PREVIOUS_PAGE("P"),
    NEXT_PAGE("N"),
    LAST_PAGE("L"),
    EXIT("E");

    private final String optionChar;

    private Option(String optionChar) {
        this.optionChar = optionChar;
    }

    public static String optionsToString() {
        return "F)irst page, P)revious page, N)ext page, L)ast page, E)xit";
    }

    public static Option getByOptionChar(String optionChar) {
        for (Option option : values()) {
            if (option.optionChar.equals(optionChar)) {
                return option;
            }
        }
        throw new IllegalArgumentException(String.valueOf(optionChar));
    }
}
