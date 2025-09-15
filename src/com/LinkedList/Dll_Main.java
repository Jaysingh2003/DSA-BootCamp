package com.LinkedList;

public class Dll_Main {
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertFirst(2);
        dll.insertFirst(3);
        dll.insertFirst(10);
        dll.insertFirst(15);
        dll.insertFirst(19);
        dll.insertLast(100);
        dll.inserAfter(10, 50);
        dll.display();
//        dll.deleteFirst();
//        dll.display();
  }
}
