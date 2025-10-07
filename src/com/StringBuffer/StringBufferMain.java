package com.StringBuffer;
import java.util.Random;
import com.StringBuffer.RandomCharecter;


public class StringBufferMain {
    public static void main(String[] args) {

        //constructer 1
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());

        //constructer 2
        StringBuffer s1 = new StringBuffer("Hello");

        //constructer 3
        StringBuffer s3 = new StringBuffer(46);
        System.out.println(s3.capacity());

        s1.append(" World");
        s1.insert(0, "Hi ");

        s1.replace(0, 3, "Hello");
        System.out.println(s1);

        Random r = new Random();

        System.out.println(RandomCharecter.genrateRandomCharecter(20));





    }
}
