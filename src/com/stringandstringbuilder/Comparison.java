package com.stringandstringbuilder;

public class Comparison {
    public static void main(String[] args) {
        String a="jay";
        String b="jay";

        System.out.println(a==b);//it will give the ture value
        System.out.println(a.equals(b));//it will give the true value

        String c = new String("kunal");
        String d = new String("kunal");
        System.out.println(c.equals(d));//.eual ponly comaper the value
        System.out.println(c==d);//so it will give the false value beacuse it point to 2 different objcets
    }

}
