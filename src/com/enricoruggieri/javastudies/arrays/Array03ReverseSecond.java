package com.enricoruggieri.javastudies.arrays;

import java.util.Arrays;

public class Array03ReverseSecond {

    public static void reverseWords(Character[] array) {
        reverseSolution(array, 0, array.length - 1);

        int leftIndex = 0;

        for (int i =0; i <= array.length; i++) {
            if (i == array.length || i == ' ') {
                reverseSolution(array,leftIndex, i - 1);
                leftIndex = i+1;
            }
        }
    }

    public static void reverseSolution(Character[] array, int leftIndex, int rightIndex) {

        while (leftIndex < rightIndex) {
            char temp = array[leftIndex];
            array[leftIndex] = array[rightIndex];
            array[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
    }

    public static void main(String[] args) {
        Character[] message = { 'c', 'a', 'k', 'e', ' ',
                'p', 'o', 'u', 'n', 'd', ' ',
                's', 't', 'e', 'a', 'l' };

        reverseWords(message);

        System.out.println(Arrays.toString(message));



    }
}
