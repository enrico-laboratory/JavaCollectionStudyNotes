package com.enricoruggieri.javastudies.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sorting {

    public static void main(String[] args) {

        Composer[] romanSchoolComposers = new Composer[6];
        romanSchoolComposers[0] = new Composer("Giovanni Pierluigi da Palestrina",
                "Palestrina", 1525, 1594);
        romanSchoolComposers[1] = new Composer("Giovanni Anumuccia",
                "Firenze", 1520, 1571);
        romanSchoolComposers[2] = new Composer("Domenico Allegri",
                "Roma", 1585, 1629);
        romanSchoolComposers[3] = new Composer("Giovanni de Maque",
                "Valenciennes", 1550, 1614);
        romanSchoolComposers[4] = new Composer("Ruggero Giovannelli",
                "Velletri", 1520, 1625);
        romanSchoolComposers[5] = new Composer("Giovanni Francesco Anerio",
                "Roma", 1569, 1630);

        System.out.println("++++++++Not Sorted++++++++");
        for (Composer composer : romanSchoolComposers) System.out.println(composer);


        System.out.println("++++++++Sorted by year of Death (Bubble Sort)++++++++");
        SortStudy.sortByDeathYear(romanSchoolComposers);
        for (Composer composer : romanSchoolComposers) System.out.println(composer);

        System.out.println("++++++++Sorted by year of Birth (Quick Sort)++++++++");
        SortStudy.sortByYearOfBirth(romanSchoolComposers);
        for (Composer composer : romanSchoolComposers) System.out.println(composer);

        System.out.println("++++++++Sorted by Place of birth Descending (Lambda / Comparator)++++++++");
        // in case of a ArrayList use Collections.sort()
        Arrays.sort(romanSchoolComposers, (Composer first, Composer second)
                -> first.getPlaceOfBirth().compareTo(second.getPlaceOfBirth()));
        Collections.reverse(Arrays.asList(romanSchoolComposers));
        // same as above but shorter
        Arrays.sort(romanSchoolComposers,
                Comparator.comparing(Composer::getPlaceOfBirth).reversed());
        for (Composer composer : romanSchoolComposers) System.out.println(composer);

        System.out.println("++++++++Sorted by year of Birth (Lambda / Comparator)++++++++");
        Arrays.sort(romanSchoolComposers, (first, second)
                -> first.getBirthYear() - second.getBirthYear());
        // same as above but shorter
        Arrays.sort(romanSchoolComposers,
                Comparator.comparingInt(Composer::getBirthYear));
        for (Composer composer : romanSchoolComposers) System.out.println(composer);

        System.out.println("++++++++Sorted by Place of birth Descending (Comparator)++++++++");
        Arrays.sort(romanSchoolComposers, new ComposerPlaceOfBirthComparator().reversed());
        // OR
        ComposerPlaceOfBirthComparator comp = new ComposerPlaceOfBirthComparator();
        Arrays.sort(romanSchoolComposers, comp.reversed());
        for (Composer composer : romanSchoolComposers) System.out.println(composer);
    }
}