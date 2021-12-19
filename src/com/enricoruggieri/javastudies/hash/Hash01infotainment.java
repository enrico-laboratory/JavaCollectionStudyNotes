package com.enricoruggieri.javastudies.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hash01infotainment {

    public static boolean isFlightDurationMovie(int flightDuration, List<Integer> movieDurations) {

        Set<Integer> movieDurationAlreadySeen = new HashSet<>();

        for (Integer firstMovie : movieDurations) {
            if (movieDurationAlreadySeen.contains(flightDuration - firstMovie)) {
                return true;
            }
            movieDurationAlreadySeen.add(firstMovie);
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> movieDurations = new ArrayList<>();
        movieDurations.add(10);
        movieDurations.add(34);
        movieDurations.add(8);
        movieDurations.add(36);
        movieDurations.add(13);

        System.out.println(isFlightDurationMovie(23, movieDurations));


    }
}
