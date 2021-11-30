package com.enricoruggieri.javastudies.map;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

        // put a key value in the map
        languages.put("Java", "Cool language");
        languages.put("Python", "super cool");
        languages.put("Algol", "Alghoritmic language");

        // result boolean key has been already used?
        System.out.println(languages.put("BASIC", "Ancient"));

        // return a default value if the key is not present
        System.out.println(languages.getOrDefault("Rust", "Not such a key"));

        // map size
        System.out.println(languages.size());



        // to avoid key to be overwritten
        var aKey = "Java";
        if (languages.containsKey(aKey)) {
            System.out.println("\"" + aKey + "\" key already used");
        } else {
            languages.put(aKey, "again a test");
        }
        // better
        languages.putIfAbsent(aKey, "Another test");

        // hot to iterated using a lambda fun
        languages.forEach((k, v) ->
                System.out.println("key=" + k + ", value=" + v));


        // Map can implement collection in three ways.
        // the first is to use the keySet() method. It returns a set of the key of the map which
        // implement the Collection interface.
        // N.B. changing in the set will affect the map and screw the iteration up, careful!
        // remove is allowed, add is not allowed
        for(String key: languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }

        System.out.println("============================");
        // similar as above, Collections of  values.
        // containsValue() return boolean
        for (String value : languages.values()) {
            System.out.println(value + ": " + languages.containsValue(value));

        }

        System.out.println("============================");
        System.out.println(languages.replace("Python", "let's how replace work..."));
        // Key does not exist return null
        System.out.println(languages.replace("Scala", "This won't work..."));
        // Replace only if the second argument exist
        if (languages.replace("BASIC", "Ancient", "Replacement")) {
            System.out.println( "\"BASIC\" Replaced!");
        }
        System.out.println("============================");

        for(String key: languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }

        System.out.println("============================");
        System.out.println(languages.remove("BASIC"));
        System.out.println("============================");

        for(String key: languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }


    }
}
