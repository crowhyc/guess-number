package com.thoughtworks.guessnumber;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NumberHolder {

    public static final String INPUT_AGAIN = "Wrong Input, input again";
    private char[] number;
    private static final String A = "A";
    private static final String B = "B";

    public NumberHolder() {
        this.number = new char[] {'5', '6', '7', '8'};
    }

    public String guess(String guess) {
        if (hasDuplicateDigit(guess)) {
            return INPUT_AGAIN;
        }
        if (Arrays.toString(this.number).equals(guess)) {
            return "4A0B";
        }
        char[] charsGuess = guess.toCharArray();
        int ACount = IntStream.range(0, 4).map(idx -> number[idx] == charsGuess[idx] ? 1 : 0).sum();
        long BCount =
                IntStream.range(0, 4)
                        .mapToLong(
                                idx ->
                                        IntStream.range(0, 4)
                                                .filter(ret -> idx != ret)
                                                .map(ret -> number[idx] == charsGuess[ret] ? 1 : 0)
                                                .sum())
                        .sum();
        return ACount + A + BCount + B;
    }

    private boolean hasDuplicateDigit(String guess) {
        return guess.chars()
                        .mapToLong(
                                guessChar -> guess.chars().filter(ret -> ret == guessChar).count())
                        .sum()
                > guess.length();
    }
}
