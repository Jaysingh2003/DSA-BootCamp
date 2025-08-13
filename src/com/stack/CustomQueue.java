package com.stack;

public class CustomQueue {
    private int[] data;
    public static  final int DEFAULT_SIZE = 10;
    private int end = 0;

     public CustomQueue() {
       this(DEFAULT_SIZE);
    }
    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length;
    }
    public boolean isEmpty() {
        return end == 0;
    }

    public boolean add(int item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        data[end++] = item; //it like data[end] = item;    end++;

        return true;
    }
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = data[0];
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return item;
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return data[0];
    }
    public void display(){
         for (int i = 0; i < end; i++) {
            System.out.print(data[i] + " ");
         }
            System.out.println("end");
    }


}
