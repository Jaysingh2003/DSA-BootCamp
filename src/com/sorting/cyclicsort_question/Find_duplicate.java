package com.sorting.cyclicsort_question;


//in this duplicate question first we have to find the index whic will we repeeated

/// step-1:- first we have to check the if index and the vlue of that index are eaqual or not
/// in the if condithi we check arr[i] != arr[correct]  measn if not equalk then swap
/// step-2:- and in the else condition it automatically chek that if they are equal and if the leemtn is alreadfy at the corrcet index
/// it means itsa an duplicate elemnt
public class Find_duplicate {

    //number from (1 to n)
    public static int duplicate(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            int correct = arr[i] - 1;

            if (arr[i] != arr[correct]) {///in this condtion it will swap to its corrcet position  only the duplicate elemt will left
                swap(arr, i, correct);
            } else {
                if (i != correct) {/// in the else condition it will check if the eleemnt which alredy at the corrcet postion
                    return arr[i]; ///  if the element after swaping is not at the corrcet index it means its postion already occupied so retun that eleemnt

                }
                i++;
            }
        }

        return -1;
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
