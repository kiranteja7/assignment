package com.kodnest.assignment;

import java.util.*;
import java.util.stream.Collectors;

import static com.kodnest.assignment.UserInputHash.userInput;

public class HashMapString {
    public static void main(String[] args) {
        String str = "ABC has completed Engineering in Nov 2021 and ABC started working as software engineer from Dec 2021 and enrolled later in the Part time MBA";
        Map<Integer, String> hashMap = new HashMap<>();
        String[] words = str.split("\\s");

        for (int i = 0; i <= words.length - 1; i++) {
            hashMap.put(i, words[i]);
        }
        System.out.println("Before removing duplicates:" +hashMap);
        Set<String> existing = new HashSet<>();
        hashMap = hashMap.entrySet()
                .stream()
                .filter(entry -> existing.add(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("After removing duplicates: " +hashMap);

        userInput(hashMap);

    }

}
