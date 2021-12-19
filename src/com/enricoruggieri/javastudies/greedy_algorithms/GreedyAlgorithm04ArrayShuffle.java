package com.enricoruggieri.javastudies.greedy_algorithms;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GreedyAlgorithm04ArrayShuffle {

    private static final Random random = new Random();

    public static void shuffle(int[] array)  {

        for (int i = 0; i < array.length; i++) {
            int randomIndex = getRandom(i, array.length - 1);
            int parkingInt = array[i];

            if (i != randomIndex) {
                array[i] = array[randomIndex];
                array[randomIndex] = parkingInt;
            }
        }
    }

    public static int getRandom(int min, int max) {
        return random.nextInt((max - min +1) + min);
    }

    public static void main(String[] args) {

        int[] arrayToShuffle = new int[]{4, 2, 87, 65, 3, -9};

        for (int number : arrayToShuffle) {
            System.out.print(number + " ");
        }

        System.out.println("\n==================");

        shuffle(arrayToShuffle);

        for (int number : arrayToShuffle) {
            System.out.print(number + " ");
        }


    }
}
