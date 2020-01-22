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

}
