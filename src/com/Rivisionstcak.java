package com;

import com.stack.Custom_exception;


public class Rivisionstcak {
      private int[] data;
      static final int DEFAULT_SIZE = 10;
      private int ptr = -1;

      public Rivisionstcak(){
          this(DEFAULT_SIZE);
      }
      public Rivisionstcak(int size){
          this.data = new int[size];
      }

      public boolean push(int val){
          if(isFull()){
              System.out.println("Stack is full");
              return  false;
          }
          ptr++;
          data[ptr]=val;
          return true;
      }
     public boolean isFull() {
       return ptr == data.length -1;
     }
     public boolean isEmpty(){
          return ptr == -1;
     }

     public int Pop()throws Custom_exception {
          if(isEmpty()){
              System.out.println("Stack is empty");
              return;
          }
          ptr--;
     }
     public int peak() throws Custom_exception  {//peak means top element ko dekhna
          if(isEmpty()){
              throw new Custom_exception("Stack is empty");
          }
          return data[ptr];
     }






}
