package com.Engineering_digst_DSA;

class MyThread1 extends Thread {
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("HI");
        }
    }
}
class MyThread2 extends Thread {
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Hello");
        }
    }
}

public class Demo {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.start();
        t2.start();  // Both run at the same time (multithreading)
    }
}