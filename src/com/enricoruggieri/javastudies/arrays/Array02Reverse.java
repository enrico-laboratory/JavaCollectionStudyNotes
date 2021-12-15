package com.enricoruggieri.javastudies.arrays;

public class Array02Reverse {

    public static char[] reverse(char[] array) {
        char temp;
        for (int i = 0; i < array.length / 2; i++ ) {
            temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void reverseSolution( char[] array) {
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

        char[] array = "abcde".toCharArray();

        System.out.println("Original Array:");
        for (char character : array) {
            System.out.print(character + ", ");
        }

        System.out.println("\nReversed Array:");
        for (char character : reverse(array)) {
            System.out.print(character + ", ");
        }

        array = "abcde".toCharArray();

        System.out.println("\nReversed Array Solution:");
        reverseSolution(array);
        for (char character : array) {
            System.out.print(character + ", ");
        }

    }
}
