package com.danny.calc.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 精度處理：結果至少可精確到小數點第六位
 */
public class PrecisionHandler {
    public static BigDecimal round(BigDecimal value) {
        // 小數六位, 四舍五入
        BigDecimal val = value.setScale(6, RoundingMode.HALF_UP);
        return val;
    }
}
