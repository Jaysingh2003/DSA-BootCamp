package com.stack;

public class Dynamiccirculerqueue extends CirculkerQueue{


    public Dynamiccirculerqueue() {
        super();
    }

    public Dynamiccirculerqueue(int size) { // it will call the parent class constructor
        super(size);
    }

    //we override the previous method
 @Override
    public boolean add(int item) {
        if (isFull()) {
            // Resize the array if full
            int[] newData = new int[data.length * 2];
            // Copy elements to the new array in the correct order
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[(front + i) % data.length];//its start from the front position
                                                            // and then move according top the next i element.
            }
            front = 0;//after tghat the front will we stating position from the beginning
            end = data.length; //and the end will be the last position in the new array
            data = newData;

        }
        return super.add(item);
    }


}
