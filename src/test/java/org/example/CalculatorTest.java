package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mock;

import java.util.function.BinaryOperator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CalculatorTest {

    Calculator calculator;
    private static final double EPS = 0.01;
    @Mock
    private BinaryOperator<Double> mockAdd = mock(BinaryOperator.class);
    @Mock
    private BinaryOperator<Double> mockSub = mock(BinaryOperator.class);
    @Mock
    private BinaryOperator<Double> mockMult = mock(BinaryOperator.class);
    @Mock
    private BinaryOperator<Double> mockDiv = mock(BinaryOperator.class);




    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CalcTestCase.csv")
    void calculateTest(String expression, double expectedResult) {
        double actualResult = calculator.calculate(expression);
        assertEquals(expectedResult, actualResult, EPS);
    }

    @Test
    void illegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1 $ 0"));
    }

    @Test
    void divideByZeroException() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate("1 / 0"));
    }

    @Test
    public void testBinaryOperators() {

        when(mockAdd.apply(anyDouble(), anyDouble())).thenReturn(3.0);

        when(mockSub.apply(anyDouble(), anyDouble())).thenReturn(4.0);

        when(mockMult.apply(anyDouble(), anyDouble())).thenReturn(20.0);

        when(mockDiv.apply(anyDouble(), anyDouble())).thenReturn(3.0);

        calculator.add = mockAdd;
        calculator.sub = mockSub;
        calculator.mult = mockMult;
        calculator.div = mockDiv;

        assertAll(
                () -> assertEquals(3.0, calculator.calculate("1 + 2"), "Что-то пошло не так"),
                () -> assertEquals(4.0, calculator.calculate("5 - 1"), "Что-то пошло не так"),
                () -> assertEquals(20.0, calculator.calculate("4 * 5"), "Что-то пошло не так"),
                () -> assertEquals(3.0, calculator.calculate("6 / 2"), "Что-то пошло не так")
        );


    }


}