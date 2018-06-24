package com.testing.hazelcast;

public class HazelcastMapping {

    private String key;
    private String value;

    public HazelcastMapping(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
