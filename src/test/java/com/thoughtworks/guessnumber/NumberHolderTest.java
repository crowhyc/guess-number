package com.thoughtworks.guessnumber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberHolderTest {

    @Test
    public void return_0A0B_when_input_1234() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("1234");
        assertEquals(result, "0A0B");
    }

    @Test
    public void return_4A0B_when_input_5678() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("5678");
        assertEquals(result, "4A0B");
    }

    @Test
    public void return_0A4B_when_input_6785() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("6785");
        assertEquals(result, "0A4B");
    }
}
