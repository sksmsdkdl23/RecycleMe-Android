package com.hackuvic.twoblocksaway.recycleme.model;

/**
 * Type class stores basic Type data.
 *
 * @author Jason, Tzu Hsiang Chen
 * @since March 11, 2018
 */
public class Type {

    private long id;
    private String name;
    private int count;

    public Type() {
    }

    public Type(long id, String name, int count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
