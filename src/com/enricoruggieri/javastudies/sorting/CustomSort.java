package com.enricoruggieri.javastudies.sorting;

import java.util.*;

public class CustomSort {

    static List<String> ORDER = List.of(
            "S", "S1", "S2", "S3", "S4",
            "A", "A1", "A2", "A3", "A4",
            "T", "T1", "T2", "T3", "T4",
            "B", "B1", "B2", "B3", "B4");

    public static void main(String[] args) {

        List<String> testArray = new ArrayList<>();

        testArray.add("S");
        testArray.add("B");
        testArray.add("T");
        testArray.add("A");
        testArray.add("S1");
        testArray.add("S2");
        testArray.add("T4");

        System.out.println("Print unsorted testArray:");
        testArray.forEach(s -> System.out.print(s + ", "));

        // with Lambda
//        testArray.sort((s, t1) -> ORDER.indexOf(s) - ORDER.indexOf(t1));

        // with Comparator
        testArray.sort(Comparator.comparingInt(s -> ORDER.indexOf(s)));


        System.out.println("\nPrint sorted testArray:");
        testArray.forEach(s -> System.out.print(s + ", "));


    }
}
