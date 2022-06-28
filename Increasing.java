package com.kodnest.assignment;

public class Increasing {
    static void checkIncreasing(int[] array) {
        boolean inc = true;
        int i;
        for (i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                inc = false;
                break;
            }
        }
        if(inc){
            System.out.println("Array is increasing");
        }
    }
}
