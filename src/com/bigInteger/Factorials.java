package com.bigInteger;

import java.math.BigInteger;

public class Factorials {

    static BigInteger factorial(int n){
        BigInteger fact = BigInteger.ONE;///constant assume
        for(int i=1; i<=n;i++){
            fact = fact.multiply(BigInteger.valueOf(i));///i ko bigInteger ma convert kiya gaya h

        }
        return fact;
    }
    public static void main(String[] args) {
        System.out.println(factorial(70));
    }


}
