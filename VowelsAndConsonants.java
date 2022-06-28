package com.kodnest.assignment;

import java.util.Scanner;

public class VowelsAndConsonants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a sentence to check each word whether it is a vowel or consonant");
        String str = scan.nextLine();
         str=str.replaceAll("\\s","").toLowerCase();
        for (int i = 0; i <= str.length() - 1; i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.println("entered character " + ch + " is a vowel");
            } else if (ch >= 'a' && ch <= 'z') {
                System.out.println("entered character " + ch + " is a consonant");
            } else {
                System.out.println("Neither vowel nor consonant");
            }
        }
    }
}
