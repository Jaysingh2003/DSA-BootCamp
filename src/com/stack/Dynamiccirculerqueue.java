package com.stack;

public class Dynamiccirculerqueue extends CirculkerQueue{


    public Dynamiccirculerqueue() {
        super();
    }

    public Dynamiccirculerqueue(int size) { // it will call the parent class constructor
        super(size);
    }

 @Override
    public boolean add(int item) {
        if (isFull()) {
            // Resize the array if full
            int[] newData = new int[data.length * 2];
            // Copy elements to the new array in the correct order
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = newData;

        }
        return super.add(item);
    }


}
