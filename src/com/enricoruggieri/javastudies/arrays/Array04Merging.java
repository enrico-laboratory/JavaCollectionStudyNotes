package com.enricoruggieri.javastudies.arrays;

import com.jogamp.opengl.FPSCounter;

public class Array04Merging {

    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {

        // set up our mergedArray
        int[] mergedArray = new int[myArray.length + alicesArray.length];

        int currentIndexAlices = 0;
        int currentIndexMine   = 0;
        int currentIndexMerged = 0;

        while (currentIndexMerged < mergedArray.length) {

            boolean isMyArrayExhausted = currentIndexMine >= myArray.length;
            boolean isAlicesArrayExhausted = currentIndexAlices >= alicesArray.length;

            // case: next comes from my array
            // my array must not be exhausted, and EITHER:
            // 1) Alice's array IS exhausted, or
            // 2) the current element in my array is less
            //    than the current element in Alice's array
            if (!isMyArrayExhausted && (isAlicesArrayExhausted
                    || (myArray[currentIndexMine] < alicesArray[currentIndexAlices]))) {

                mergedArray[currentIndexMerged] = myArray[currentIndexMine];
                currentIndexMine++;

                // case: next comes from Alice's array
            } else {
                mergedArray[currentIndexMerged] = alicesArray[currentIndexAlices];
                currentIndexAlices++;
            }

            currentIndexMerged++;
        }

        return mergedArray;
    }

    public static int[] merge(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];

        int i = 0;
        int j = 0;
        int currentIndex = 0;

        while (currentIndex < mergedArray.length){

            boolean isArray1Exhausted = i >= array1.length;
            boolean isArray2Exhausted = j >= array2.length;

            if (!isArray1Exhausted && (isArray2Exhausted || array1[i] < array2[j])) {
                mergedArray[currentIndex] = array1[i];
                i++;
            } else {
                mergedArray[currentIndex] = array2[j];
                j++;
            }
            currentIndex++;
        }
        return mergedArray;
    }

    public static void main(String[] args) {

        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

        for (int index : merge(myArray, alicesArray)) {
            System.out.println(index);
        }
    }
}
