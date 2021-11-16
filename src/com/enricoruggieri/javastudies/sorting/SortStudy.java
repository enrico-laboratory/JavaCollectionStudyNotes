package com.enricoruggieri.javastudies.sorting;

public class SortStudy {
    // Bubble Sort
    public static void sortByYearOfBirth(Composer[] composers) {
        for (int unsortedPartition = composers.length - 1; unsortedPartition > 0; unsortedPartition --) {

            for (int i = 0; i < unsortedPartition; i ++) {
                if (composers[i].getBirthYear() > composers[i + 1].getBirthYear()) {
                    Composer temp = composers[i];
                    composers[i] = composers[i + 1];
                    composers[i + 1] = temp;
                }
            }
        }
    }
    // Quick Sort
    public static void sortByDeathYear(Composer[] composers) {
        sortByDeathYear(composers, 0, composers.length);
    }
    private static void sortByDeathYear(Composer[] composers, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(composers, start, end);
        sortByDeathYear(composers, start, pivotIndex);
        sortByDeathYear(composers, pivotIndex + 1, end);
    }

    private static int partition(Composer[] composers, int start, int end) {
        Composer pivot = composers[start];
        int i = start;
        int j = end;

        while (i < j) {

            while (i < j && composers[--j].getDeathYear() >= pivot.getDeathYear()) ;
            if (i < j) {
                composers[i] = composers[j];
            }
            while (i < j && composers[++i].getDeathYear() <= pivot.getDeathYear()) ;
            if (i < j) {
                composers[j] = composers[i];
            }
            composers[j] = pivot;
        }
        return j;
    }

}

