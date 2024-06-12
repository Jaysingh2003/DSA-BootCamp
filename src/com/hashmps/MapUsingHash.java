package com.hashmps;

public class MapUsingHash {

    private Entity[] entity;

    public class Entity {
        String key;
        String value;

        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }

    }
    MapUsingHash(){
        entity = new Entity[100];
    }

    public void put(String key, String value) {
        int hash = Math.abs( key.hashCode() % entity.length);//simple hash fxn to calculate index
        entity[hash] = new Entity(key, value);// Collision handling is not implemented in this simple example //overwrite existing value if collision occurs
    }

    public String get(String key) {
        int hash = Math.abs( key.hashCode() % entity.length);
        Entity e = entity[hash];
        if (e != null && e.key.equals(key)) {
            return e.value;
        }
        return null; // Return null if key not found or collision occurs
    }

    public void  remove(String key){
        int hash = Math.abs( key.hashCode() % entity.length);
        if(entity[hash] != null && entity[hash].key.equals(key)){
            entity[hash] = null; // Remove the key-value pair by setting it to null
        }
    }





}
