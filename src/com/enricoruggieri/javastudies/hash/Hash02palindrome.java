package com.enricoruggieri.javastudies.hash;

import java.util.HashSet;
import java.util.Set;

public class Hash02palindrome {

    public static boolean hasPalindromePermutation(String theString) {

        // track characters we've seen an odd number of times
        Set<Character> unpairedCharacters = new HashSet<>();

        for (int i = 0; i < theString.length(); i++) {
            char c = theString.charAt(i);
            if (unpairedCharacters.contains(c)) {
                unpairedCharacters.remove(c);
            } else {
                unpairedCharacters.add(c);
            }
        }

        // the string has a palindrome permutation if it
        // has one or zero characters without a pair
        return unpairedCharacters.size() <= 1;
    }

    public static boolean isPalindrome(String string) {
        Set<Character> stringSet = new HashSet<>();
        char[] string1 = string.toCharArray();
        for (Character character : string1) {
            stringSet.add(character);
        }
        System.out.println("StringSet is even: " + (stringSet.size() % 2 == 0));
        if (stringSet.size() % 2 == 0 && stringSet.size() == string1.length / 2) {
            return true;
        } else if (stringSet.size() % 2 != 0 && stringSet.size() - 1 == string1.length / 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String pal1 = "civic";
        String pal2 = "cciiv";
        String pal3 = "anna";
        String pal4 = "nnaa";
        String pal5 = "gelato";

        System.out.println(isPalindrome(pal2));
    }
}
