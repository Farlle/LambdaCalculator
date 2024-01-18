package com.company.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    void testCalculateAddition() {
        BinaryOperator<Double> addMock = Mockito.mock(BinaryOperator.class);
        when(addMock.apply(2.0, 3.0)).thenReturn(5.0);
        calculator.add = addMock;

        assertEquals(5, calculator.calculate("2 3 +"), 0.001);
        verify(addMock, times(1)).apply(2.0, 3.0);
    }

    @Test
    void testCalculateSubtraction() {
        BinaryOperator<Double> subMock = Mockito.mock(BinaryOperator.class);
        when(subMock.apply(3.0, 2.0)).thenReturn(1.0);
        calculator.sub = subMock;

        assertEquals(1, calculator.calculate("3 2 -"), 0.001);
        verify(subMock, times(1)).apply(3.0, 2.0);
    }

    @Test
    void testCalculateMultiplication() {
        BinaryOperator<Double> multMock = Mockito.mock(BinaryOperator.class);
        when(multMock.apply(2.0, 3.0)).thenReturn(6.0);
        calculator.mult = multMock;

        assertEquals(6, calculator.calculate("2 3 *"), 0.001);
        verify(multMock, times(1)).apply(2.0, 3.0);
    }

    @Test
    void testCalculateDivision() {
        BinaryOperator<Double> divMock = Mockito.mock(BinaryOperator.class);
        when(divMock.apply(6.0, 3.0)).thenReturn(2.0);
        calculator.div = divMock;

        assertEquals(2, calculator.calculate("6 3 /"), 0.001);
        verify(divMock, times(1)).apply(6.0, 3.0);
    }
}