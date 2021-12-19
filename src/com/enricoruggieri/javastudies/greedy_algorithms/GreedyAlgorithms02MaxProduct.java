package com.enricoruggieri.javastudies.greedy_algorithms;

public class GreedyAlgorithms02MaxProduct {

    public static int getMaxProduct(int[] numbers) {

        if (numbers.length < 3) {
            throw new IllegalArgumentException();
        }

        int highestProductOf3 = numbers[0] * numbers[1] * numbers[2];
        int highestProductOf2 = numbers[0] * numbers[1];
        int highest = Math.max(numbers[0], numbers[1]);
        int lowestProductOf2 = numbers[0] * numbers[1];
        int lowest = Math.min(numbers[0], numbers[1]);

        for (int i = 2; i < numbers.length; i++) {
            int current = numbers[i];

            highestProductOf3 = Math.max(Math.max(
                    highestProductOf3,
                    current * highestProductOf2),
                    current * lowestProductOf2);

            highestProductOf2 = Math.max(Math.max(
                    highestProductOf2,
                    current * highest),
                    current * lowest);

            lowestProductOf2 = Math.min(Math.min(
                    lowestProductOf2,
                    current * lowest),
                    current * highest);

            highest = Math.max(current, highest);

            lowest = Math.min(current, lowest);
        }

        return highestProductOf3;
    }

    public static void main(String[] args) {

        int[] numbers = new int[]{4, 7, 10, 2, 98, 3, 56};

        System.out.println(getMaxProduct(numbers));
    }
}
