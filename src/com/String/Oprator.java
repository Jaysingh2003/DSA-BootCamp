package com.String;

import com.array.Arraylist;

import java.util.ArrayList;

public class Oprator {
    public static void main(String[] args) {
        System.out.println('a' + 'b');
        System.out.println("a" + "b");
        //it will compare with the ascii value
        System.out.println((char)('a'+ 3));
        //when a integer is added  with the string it will use the Integer(wrapper class) using the toString() method
        System.out.println("a"+1);

        System.out.println("jay"+ new ArrayList<>());
        System.out.println(new Integer(45)+ "jay" +new ArrayList<>());
    }

}
