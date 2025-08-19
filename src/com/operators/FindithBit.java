package com.operators;

public class FindithBit{
    public static void main(String[] args) {
    int num = 17; // Binary: 10001
    int i = 5; //
    int ithBit = findithdigit(num, i);
        System.out.println(ithBit);
    }
    static int findithdigit(int num,int n){
   //  return num & (1<<n-1);//it will return the 0,2^i
   return (num>>(n-1)) & 1; // This will return the ith bit of the number

    }
}
/*
✅ Example with num = 17 (10001)
	•	findithdigit(17, 1) → 10001 >> 0 = 10001 → 10001 & 1 = 1
	•	findithdigit(17, 2) → 10001 >> 1 = 1000  → 1000 & 1 = 0
	•	findithdigit(17, 5) → 10001 >> 4 = 1     → 1 & 1 = 1

 */