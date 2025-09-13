package com.operators;

//this is the classic problem: you can either multiply by 2 or subtract 1,
// start at a number n and must reach target m in the minimum number of operations.
// Best trick: work backwards from m to n.
public class FindStepsOperations {
    public static void main(String[] args) {
        int num = 5;
        int target = 17;
        System.out.println(steps(num, target));
        System.out.println(steps2(num, target));

    }

    static int steps(int num, int target) {

        if (num >= target) {
            return num - target;
        }
        int steps = 0;
        while (num < target) {
            if (target % 2 == 0) {
                target = target / 2;
            } else {
                target = target + 1;
            }
            steps++;

        }
        steps = steps + (num - target);
        return steps;
    }

    //another way
    static int steps2(int num, int target) {
        if (num >= target) {
            return num - target;
        }
        if (target % 2 == 0) {
            return 1 + steps2(num, target / 2);
        } else {
            //recursive
            return 1 + steps2(num, target + 1);//
        }

    }

}
