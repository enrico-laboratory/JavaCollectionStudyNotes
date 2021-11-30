package com.enricoruggieri.javastudies.map;

import java.util.HashMap;
import java.util.Map;

/**
 *  Example coming form Java Programming Masterclass covering Java 11 & Java 17
 *  Udemy course by Tim Buchalka.
 */

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>();
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        // create a new Map that contain all the keys of "exits" map
        // so exits would not be affected if the user wants to change the map.
        return new HashMap<>(exits);
    }
}
