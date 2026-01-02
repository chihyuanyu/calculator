package com.danny.calc;

import java.math.BigDecimal;

import com.danny.calc.utils.PrecisionHandler;

/**
 * 減法
 */
public class SubtractCommand implements Command {

    protected Calculator calculator;
    protected BigDecimal operand;
    protected BigDecimal previousValue;

    public SubtractCommand(Calculator calculator, BigDecimal operand) {
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
        calculator.setValue(PrecisionHandler.round(calculator.getValue().subtract(operand)));
    }

    @Override
    public void undo() {
        calculator.setValue(previousValue);
    }
}
