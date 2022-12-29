package com.sir.soir.sir2022;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);
        assertEquals(3, result);
    }

    @Test
    void sub() {
        Calculator calculator = new Calculator();
        int result = calculator.sub(1, 2);
        assertEquals(-1, result);
    }

    @Test
    void mul() {
        Calculator calculator = new Calculator();
        int result = calculator.mul(1, 2);
        assertEquals(2, result);
    }

    @Test
    void div() {
        Calculator calculator = new Calculator();
        int result = calculator.div(1, 2);
        assertEquals(0, result);
    }
}