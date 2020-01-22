package com.thoughtworks.guessnumber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberHolderTest {

    @Test
    public void return_0A0B_when_input_1234() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("1234");
        assertEquals("0A0B", result);
    }

    @Test
    public void return_4A0B_when_input_5678() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("5678");
        assertEquals("4A0B", result);
    }

    @Test
    public void return_0A4B_when_input_6785() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("6785");
        assertEquals("0A4B", result);
    }

    @Test
    public void return_2A2B_when_input_5876() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("5876");
        assertEquals("2A2B", result);
    }
}
