package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorServiceTest {

    @Test
    public void addReturnsSumOfArguments() {
        CalculatorService service = new CalculatorService();

        int result = service.add(4,5);
        assertEquals(9, result);
    }

    @Test
    public void subtractReturnsSubtractionOfArguments() {
        CalculatorService service = new CalculatorService();

        int result = service.subtract(4,5);
        assertEquals(-1, result);
    }
}
