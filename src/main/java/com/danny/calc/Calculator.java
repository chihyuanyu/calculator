package com.danny.calc;

import java.math.BigDecimal;

/**
 * 保存目前的計算結果
 */
public class Calculator {
    private BigDecimal value = new BigDecimal(0.0);

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}