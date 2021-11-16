package com.enricoruggieri.javastudies.collections;

public class Composers {

    private final String name;
    private final String placeOfBirth;
    private final int birthYear;
    private final int deathYear;

    public Composers(String name, String placeOfBirth, int birthYear, int deathYear) {
        if ( birthYear < 1500 || birthYear > 1700  ) {
            throw new IllegalArgumentException("Invalid year of birth");
        }
        if ( deathYear < 1550 || deathYear > 1700  ) {
            throw new IllegalArgumentException("Invalid year of death");
        }
        if (name.length() < 4 ) {
            throw new IllegalArgumentException("Invalid name");
        }
        if (placeOfBirth.length() < 3 ) {
            throw new IllegalArgumentException("Invalid place of birth");
        }
        this.name = name;
        this.placeOfBirth = placeOfBirth;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public String getName() {
        return name;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    @Override
    public String toString() {
        return "com.enricoruggieri.javastudies.collections.Composers{" +
                "name='" + name + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                '}';
    }
}
