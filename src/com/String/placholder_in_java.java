package com.String;

public class placholder_in_java {
    public static void main(String[] args) {
        float a = 23.4556f;//% is used her as the p[pacholder
        System.out.printf("after roundof of a with the two decimal place %.2f" ,a);
        System.out.println("");
        System.out.printf("hello %s","jay");//placeholder for the string
        System.out.println("");
        int age = 25;
        System.out.printf("Name: %s, Age: %d, Score: %.2f\n", "jay", age, a);


    }


}
//other placeholder which are use inn the java
//%c - Character
//%d - Decimal number (base 10)
//%e - Exponential floating-point number
//%f - Floating-point number
//%i - Integer (base 10)
//%o - Octal number (base 8)
//%s - String
//%u - Unsigned decimal (integer) number
//%x - Hexadecimal number (base 16)
//%t - Date/time
//%n - Newline