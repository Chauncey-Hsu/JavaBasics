package com.chuanqi.grammer;

import java.math.BigDecimal;

/**
 * @Description
 * @Author Chauncey
 * @Date 2020/5/22 14:28
 * @Version 1.0
 **/
public class FloatTest {
    public static void main(String[] args) {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        // 都不对
//        System.out.println((a == b));
//        System.out.println((a.equal(b)));

        Float c = 1.0f - 0.9f;
        Float d = 0.9f - 0.8f;
        // 都不对
//        System.out.println(c == d);
//        System.out.println(c.equals(d));

//        浮点数判断是否相等，正确方法一。

        float diff = 1e-6f;
        if (Math.abs(a - b) < diff) {
            System.out.println("true");
        }
//        浮点数判断是否相等，正确方法二。
        BigDecimal h = new BigDecimal("1.0");
        BigDecimal i = new BigDecimal("0.9");
        BigDecimal j = new BigDecimal("0.8");
        BigDecimal x = h.subtract(i);
        BigDecimal y = i.subtract(j);
        if (x.equals(y)) {
            System.out.println("true");
        }
    }

}
