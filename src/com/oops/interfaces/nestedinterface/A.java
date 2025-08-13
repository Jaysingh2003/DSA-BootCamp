package com.oops.interfaces.nestedinterface;

public class A {
   public   interface nestedInterface {
       boolean isodd(int num);
    }

    public static class B implements nestedInterface {

       //note the acces modifier of the method isodd must be greater than the original interface where it defined
          @Override
          public boolean isodd(int num) {
                return num % 2 != 0;
          }
     }
}
