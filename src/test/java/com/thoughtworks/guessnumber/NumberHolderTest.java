package com.thoughtworks.guessnumber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumberHolderTest {

    @Test
    public void return_0A0B_when_input_1234() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("1234");
        assertEquals("1234 0A0B", result);
    }

    @Test
    public void return_4A0B_when_input_5678() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("5678");
        assertEquals("5678 4A0B", result);
    }

    @Test
    public void return_0A4B_when_input_6785() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("6785");
        assertEquals("6785 0A4B", result);
    }

    @Test
    public void return_2A2B_when_input_5876() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("5876");
        assertEquals("5876 2A2B", result);
    }

    @Test
    public void return_Wrong_Input_when_input_5567() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("5567");
        assertEquals("Wrong Input, input again", result);
    }

    @Test
    public void return_Wrong_Input_when_input_123() {
        NumberHolder numberHolder = new NumberHolder();
        String result = numberHolder.guess("123");
        assertEquals("Wrong Input, input again", result);
    }

    @Test
    public void return_2_times_result_and_input_numbers_when_input_4567_and_6789() {
        NumberHolder numberHolder = new NumberHolder();
        numberHolder.guess("4567");
        String result = numberHolder.guess("6789");
        assertEquals("4567 0A3B,6789 0A3B",result);
    }

    @Test
    public void return_Game_Over_when_input_number_7_times() {
        NumberHolder numberHolder = new NumberHolder();
        numberHolder.guess("4567");
        numberHolder.guess("4567");
        numberHolder.guess("4567");
        numberHolder.guess("4567");
        numberHolder.guess("4567");
        numberHolder.guess("4567");
        String result = numberHolder.guess("6789");
        assertEquals("Game Over!!",result);
    }
}
