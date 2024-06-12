package com.hashmps;

import java.util.LinkedList;

public class MapUsingHash_Improved_Version {
    private static class Entity {
        String key;
        String value;

        Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    /// this is the way to initialize the array of linkedlist -- LinkedList<Integer>[] lists = new LinkedList[10];
    private LinkedList<Entity>[] buckets;
    private int capacity = 16;
    private int size = 0;
    private final double LOAD_FACTOR = 0.75;

    MapUsingHash_Improved_Version() {
        buckets = new LinkedList[capacity];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;///simple hash fxn to calculate index
    }

    public void put(String key, String value) {
        int index = hash(key);
     /// Note:- buckets is an array of LinkedLists.
        /// Index → LinkedList → (Entity, Entity, Entity...)
        if (buckets[index] == null) {/// Initialize bucket if it doesn't exist
            buckets[index] = new LinkedList<>();
        }

        for (Entity e : buckets[index]) {/// Check for existing key and update value if found
            if (e.key.equals(key)) {
                e.value = value;  // Update existing key
                return;
            }
        }
        /// If key not found in bucket:--> Now it inserts new key-value pair into LinkedList.
        buckets[index].add(new Entity(key, value));///
        size++;

        if ((double) size / capacity > LOAD_FACTOR) {/// Check Load Factor
            resize();
        }
    }

    public String get(String key) {
        int index = hash(key);

        if (buckets[index] != null) {
            for (Entity e : buckets[index]) {
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);

        if (buckets[index] != null) {
            buckets[index].removeIf(e -> e.key.equals(key));
            size--;
        }
    }

    private void resize() {
        capacity *= 2;
        LinkedList<Entity>[] oldBuckets = buckets;
        buckets = new LinkedList[capacity];
        size = 0;

        for (LinkedList<Entity> bucket : oldBuckets) {/// Rehashing all existing key-value pairs into new buckets array
            if (bucket != null) {
                for (Entity e : bucket) {
                    put(e.key, e.value);
                }
            }
        }
    }
}

