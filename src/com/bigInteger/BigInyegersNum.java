package com.bigInteger;
import java.math.BigInteger;

public class BigInyegersNum {
    public static void main(String[] args) {
        int a = 20;
        int b = 30;

        BigInteger bigA = BigInteger.valueOf(33);
        BigInteger bigB = BigInteger.valueOf(344767533L);
        ///For large numbers outside long range, use string constructor
        BigInteger bigC = new BigInteger("3447425367533");

        // Example operations
        /// these are the objects that is why use the methods not a+b
        BigInteger sum = bigA.add(bigB);
        BigInteger product = bigB.multiply(bigC);
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }

    /// note valueof is static type  and the string tpye is not ststic so we have to craete it constructer using tjhe
     /// new keyword


}
