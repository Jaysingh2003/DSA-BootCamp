package com.bigInteger;
import java.math.BigDecimal;

public class Bigdecimal {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.03");
        BigDecimal b = new BigDecimal("0.04");
        System.out.println(a.subtract(b));

        BigDecimal b1 = new BigDecimal("3492525555.6376354547");
        BigDecimal b2 = new BigDecimal("34925255.637647");
        System.out.println(b1.subtract(b2));
        System.out.println(b1.multiply(b2));
        System.out.println(b1.pow(2));



    }
}
