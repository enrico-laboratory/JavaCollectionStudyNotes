package com.enricoruggieri.javastudies.sorting;

import java.util.Comparator;

public class ComposerPlaceOfBirthComparator implements Comparator<Composer> {

    @Override
    public int compare(Composer composer1, Composer composer2) {
        return composer1.getPlaceOfBirth().compareTo(composer2.getPlaceOfBirth());
    }
}
