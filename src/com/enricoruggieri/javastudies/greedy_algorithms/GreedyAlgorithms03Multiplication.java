package com.enricoruggieri.javastudies.greedy_algorithms;

public class GreedyAlgorithms03Multiplication {

    public static int[] getMultiplication(int[] numbers) {
        int[] multipliedNumbers = new int[numbers.length];

        int productSoFar = 1;

        for (int i = 0; i < numbers.length; i++) {
            multipliedNumbers[i] = productSoFar;
            productSoFar *= numbers[i];
        }

        productSoFar = 1;

        for (int i = numbers.length - 1; i >= 0; i--) {
            multipliedNumbers[i] = multipliedNumbers[i] * productSoFar;
            productSoFar *= numbers[i];
        }
        return  multipliedNumbers;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 1, 2, 5, 6, 4};
        for (int number : getMultiplication(numbers)) {
            System.out.println(number);
        }
    }
}
