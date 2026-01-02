package com.danny.calc;

import java.math.BigDecimal;

import com.danny.calc.utils.PrecisionHandler;

/**
 * 乘法
 */
public class MultiplyCommand implements Command {

    protected Calculator calculator;
    protected BigDecimal operand;
    protected BigDecimal previousValue;

    public MultiplyCommand(Calculator calculator, BigDecimal operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    @Override
    public void backup() {
        previousValue = calculator.getValue();
    }

    @Override
    public void execute() {
        backup();
        calculator.setValue(PrecisionHandler.round(calculator.getValue().multiply(operand)));
    }

    @Override
    public void undo() {
        calculator.setValue(previousValue);
    }
}
