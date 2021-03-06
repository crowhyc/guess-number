package com.thoughtworks.guessnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NumberHolder {

    private static final String INPUT_AGAIN = "Wrong Input, input again";
    private static final int NUMBER_DIGIT = 4;
    private char[] number;
    private static final String A = "A";
    private static final String B = "B";
    private List<String> guessStore = new ArrayList<>();
    private static final int GUESS_TIMES = 6;
    private static final String GAME_OVER = "Game Over!!";

    public NumberHolder(NumberGen numberGen) {
        this.number = String.valueOf(numberGen.genNum()).toCharArray();
    }

    public String guess(String guess) {
        if (guessStore.size() >= GUESS_TIMES) {
            return GAME_OVER;
        }
        if (notEnoughDigit(guess)) {
            return INPUT_AGAIN;
        }
        if (hasDuplicateDigit(guess)) {
            return INPUT_AGAIN;
        }
        char[] charsGuess = guess.toCharArray();
        int ACount = countSameDigit(charsGuess);
        int BCount = countSameDigitButWrongLocation(charsGuess);
        guessStore.add(buildResult(guess, ACount, BCount));
        return String.join(",", guessStore);
    }

    private String buildResult(String guess, int ACount, int BCount) {
        return guess + " " + ACount + A + BCount + B;
    }

    private int countSameDigitButWrongLocation(char[] charsGuess) {
        return IntStream.range(0, 4)
                .map(
                        idx ->
                                IntStream.range(0, 4)
                                        .filter(ret -> idx != ret)
                                        .map(ret -> number[idx] == charsGuess[ret] ? 1 : 0)
                                        .sum())
                .sum();
    }

    private int countSameDigit(char[] charsGuess) {
        return IntStream.range(0, 4).map(idx -> number[idx] == charsGuess[idx] ? 1 : 0).sum();
    }

    private boolean notEnoughDigit(String guess) {
        return guess.length() != NUMBER_DIGIT;
    }

    private boolean hasDuplicateDigit(String guess) {
        return guess.chars()
                        .mapToLong(
                                guessChar -> guess.chars().filter(ret -> ret == guessChar).count())
                        .sum()
                > guess.length();
    }
}
