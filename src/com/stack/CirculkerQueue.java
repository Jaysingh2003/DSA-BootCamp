package com.stack;

public class CirculkerQueue {
    protected int[] data;
  private static final int DEFAULT_SIZE = 10;
   protected  int front =0;
    protected int end =0;
    private int size = 0;// Current size of the queue


    public CirculkerQueue(){
        this(DEFAULT_SIZE);
    }
    public CirculkerQueue(int size) {
        this.data = new int[size];

    }
    public boolean isFull() {
        return size == data.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean add(int item) {
        if (isFull()) {
            System.out.println("Queue is full, cannot add " + item);
            return false;
        }
        data[end] = item;
        end = (end + 1) % data.length; // Circular increment
        size++;
        return true;
    }

    public int remove() {
        if(isEmpty()) {
       throw new IllegalStateException("Queue is empty, cannot remove");
        }
        int removedItem = data[front];
        data[front] = 0; // Optional: Clear the removed item
        front = (front + 1) % data.length; // Circular increment
        size--;
        return removedItem;

    }
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty, cannot peek");
        }
        return data[front];
    }
    //fix the dispalay fxn

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        do{
            System.out.print(data[i] + " ");
            i++;
            i %= data.length; // Circular increment
        } while (i != end);
        System.out.println();

       }

    }

