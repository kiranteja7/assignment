package com.kodnest.assignment;

import java.util.Scanner;

import static com.kodnest.assignment.Decreasing.checkDecreasing;
import static com.kodnest.assignment.Increasing.checkIncreasing;


public class Arrays {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int size= scan.nextInt();
        int[] arr =new int[size];
        for(int i=0;i<size;i++){
            char ch=scan.next().charAt(0);
            int value=Integer.valueOf(ch);
            arr[i]=value;
        }
        boolean flag=true;
        for(int i=0;i<arr.length;i++){
            int value=arr[i];
            if(value >= 65 && value <= 90 || value>=97 && value<=122){
                flag=false;
            }
        }

        if(flag){
            System.out.println("array is valid ");
        }
        else {
            System.out.println("not a valid number array");
        }
        checkIncreasing(arr);
        checkDecreasing(arr);
    }
    }
