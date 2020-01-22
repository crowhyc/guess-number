package com.thoughtworks.guessnumber;

public class NumberHolder {
    private String number;

    public NumberHolder() {
        this.number = "5678";
    }

    public String guess(String s) {
        if (number.equals(s)) {
            return "4A0B";
        }
        return "0A0B";
    }
}
