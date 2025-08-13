package com.stack;

public class Dynamicstack extends CustomStack {


    public Dynamicstack() {
        super();
    }

    public Dynamicstack(int size) { //it wioll cal the parent class constructor
        super(size);
    }

    // Push operation with dynamic resizing to use tha sam emethod as the parent class
    //and we want that every thing sholud we same except the body of the push method then we will override the push method

    @Override
    public boolean push(int x) {
        if (isFull()) {
            int newCapacity = stack.length * 2;
            int[] newStack = new int[newCapacity];
            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;

            // ❗❗ Update the capacity field
            // Since it's private in the parent class, you need to change its access to protected.
            super.capacity = newCapacity;
        }

        return super.push(x);
    }


}