package com.rainer.pawel.intro._4_;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    /*
        Napisz implementację interfejsu IPositiveIntegerCalculator, która przejdzie poniższe testy:
     */

    //    private IPositiveIntegerCalculator calculator = new YourCalculatorImplementation();
    private IPositiveIntegerCalculator calculator;

    @Test
    void shouldAdd() {
        // given
        int a = 10;
        int b = 13;

        int expectedSum = 23;

        // when
        int actualSum = calculator.add(a, b);

        // then
        assertEquals(expectedSum, actualSum);
    }

    // Parametrized test -> wykonuje się kilka razy z podanymi wartosciami https://www.baeldung.com/parameterized-tests-junit-5
    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            -3 |  2
             5 | -4
            -6 | -8
            """)
    void shouldThrowIfAnyArgumentPassedToAddIsNegative(int a, int b) {
        // expect
        assertThrows(CalculatorException.class, () -> calculator.add(a, b));
    }

    @Test
    void shouldMultiply() {
        // given
        int a = 10;
        int b = 3;

        int expectedProduct = 30;

        // when
        int actualProduct = calculator.multiply(a, b);

        // then
        assertEquals(expectedProduct, actualProduct);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            -3 |  2
             5 | -4
            -6 | -8
            """)
    void shouldThrowIfAnyArgumentPassedToMultiplyIsNegative(int a, int b) {
        // expect
        assertThrows(CalculatorException.class, () -> calculator.multiply(a, b));
    }
}