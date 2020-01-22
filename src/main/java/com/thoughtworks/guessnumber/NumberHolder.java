package com.thoughtworks.guessnumber;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NumberHolder {
    private char[] number;
    private static final String A = "A";
    private static final String B = "B";

    public NumberHolder() {
        this.number = new char[] {'5', '6', '7', '8'};
    }

    public String guess(String guess) {
        if (Arrays.toString(this.number).equals(guess)) {
            return "4A0B";
        }
        char[] charsGuess = guess.toCharArray();
        int ACount =
                IntStream.range(0, 4).map(idx -> number[idx] == charsGuess[idx] ? 1 : 0).sum();
        long BCount =
                IntStream.range(0, 4)
                        .mapToLong(
                                idx ->
                                        IntStream.range(0, 4)
                                                .filter(ret -> idx != ret)
                                                .map(ret -> number[idx] == charsGuess[ret] ? 1 : 0)
                                                .sum())
                        .sum();
        return ACount + "A" + BCount + "B";
    }
}
