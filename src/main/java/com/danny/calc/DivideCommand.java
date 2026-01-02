package com.danny.calc;

import java.math.BigDecimal;

import com.danny.calc.utils.PrecisionHandler;

/**
 * 除法
 */
public class DivideCommand implements Command {

    protected Calculator calculator;
    protected BigDecimal operand;
    protected BigDecimal previousValue;

    public DivideCommand(Calculator calculator, BigDecimal operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    @Override
    public void backup() {
        previousValue = calculator.getValue();
    }

    @Override
    public void execute() {
        // 除數不能為0
        if (operand.equals(BigDecimal.ZERO)) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        backup();
        calculator.setValue(PrecisionHandler.round(calculator.getValue().divide(operand)));
    }

    @Override
    public void undo() {
        calculator.setValue(previousValue);
    }
}
