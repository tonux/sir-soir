package com.sir.soir.sir2022;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
         calculator = new Calculator();
    }

    @Test
    void add() {
        int result = calculator.add(1, 2);
        assertEquals(3, result);
    }

    @Test
    void sub() {
        int result = calculator.sub(1, 2);
        assertEquals(-1, result);
    }

    @Test
    void mul() {
        int result = calculator.mul(1, 2);
        assertEquals(2, result);
    }

    @Test
    void div() {
        int result = calculator.div(1, 2);
        assertEquals(0, result);
    }

    @Test
    void divException() {
        // assert that the exception is thrown
        assertThrows(ArithmeticException.class, () -> {
            calculator.div(1, 0);
        });
    }
}