package com.danny.calc;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import com.danny.calc.utils.PrecisionHandler;

public class CalculationManagerTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAddition() {
        CalculationManager manager = new CalculationManager();
        manager.execute(new AddCommand(calculator, new BigDecimal("3.1415926")));
        assertEquals(PrecisionHandler.round(new BigDecimal("3.1415926")), calculator.getValue());
    }

    @Test
    void testSubtraction() {
        CalculationManager manager = new CalculationManager();
        manager.execute(new AddCommand(calculator, new BigDecimal("5.0")));
        manager.execute(new SubtractCommand(calculator, new BigDecimal("2.7182818")));
        assertEquals(PrecisionHandler.round(new BigDecimal("2.2817182")),
                calculator.getValue());
    }

    @Test
    void testMultiplication() {
        CalculationManager manager = new CalculationManager();
        manager.execute(new AddCommand(calculator, new BigDecimal("5.0")));
        manager.execute(new MultiplyCommand(calculator, new BigDecimal("2.0")));
        assertEquals(PrecisionHandler.round(new BigDecimal("10.0")),
                calculator.getValue());
    }

    @Test
    void testDivision() {
        CalculationManager manager = new CalculationManager();
        manager.execute(new AddCommand(calculator, new BigDecimal("6.0")));
        manager.execute(new DivideCommand(calculator, new BigDecimal("2.0")));
        assertEquals(PrecisionHandler.round(new BigDecimal("3.0")),
                calculator.getValue());
    }

    @Test
    void testDivisionByZero() {
        CalculationManager manager = new CalculationManager();
        manager.execute(new AddCommand(calculator, new BigDecimal("6.0")));
        assertThrows(ArithmeticException.class, () -> {
            manager.execute(new DivideCommand(calculator, BigDecimal.ZERO));
        });
    }

    @Test
    void testUndoRedo() {
        CalculationManager manager = new CalculationManager();
        manager.execute(new AddCommand(calculator, new BigDecimal("1.0")));
        manager.execute(new AddCommand(calculator, new BigDecimal("2.0")));
        manager.undo();
        assertEquals(PrecisionHandler.round(new BigDecimal("1.0")),
                calculator.getValue());

        manager.execute(new AddCommand(calculator, new BigDecimal("3.0")));
        manager.execute(new AddCommand(calculator, new BigDecimal("4.0")));
        manager.redo();
        assertEquals(PrecisionHandler.round(new BigDecimal("8.0")),
                calculator.getValue());
    }

    @Test
    void testNegativeNumbers() {
        CalculationManager manager = new CalculationManager();
        manager.execute(new AddCommand(calculator, new BigDecimal("-1.5")));
        manager.execute(new AddCommand(calculator, new BigDecimal("-2.5")));
        assertEquals(PrecisionHandler.round(new BigDecimal("-4.0")),
                calculator.getValue());

        manager.execute(new SubtractCommand(calculator, new BigDecimal("2.0")));
        assertEquals(PrecisionHandler.round(new BigDecimal("-6.0")),
                calculator.getValue());
    }
}
