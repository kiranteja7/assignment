package com.kodnest.assignment;

public class Decreasing {
    static void checkDecreasing(int[] array) {
        boolean dec = true;
        int i;
        for (i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                dec = false;
                break;
            }
        }
        if (dec) {
            System.out.println("Array is decreasing");
        }
    }
}
