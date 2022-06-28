package com.kodnest.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInputHash {
    public static void userInput(Map<Integer, String> user) {


        Scanner scan = new Scanner(System.in);
        System.out.println("enter the word in a sentence to replace");
        String replace = scan.nextLine();
        System.out.println("enter which you to replace that word in that sentence");
        String word = scan.nextLine();

        user.forEach((Key,value) -> {
               if(value.equals(replace)) {
                   value = value.replace(replace, word);
               }
               System.out.print(value+" ");
            });

        }
    }