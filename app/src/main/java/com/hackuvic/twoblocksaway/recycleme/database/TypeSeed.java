package com.hackuvic.twoblocksaway.recycleme.database;

import com.hackuvic.twoblocksaway.recycleme.model.Type;

/**
 * @author Jason, Tzu Hsiang Chen
 * @since March 11, 2018
 */

public class TypeSeed {

    private Type[] types;

    public TypeSeed () {
        types = new Type[8];
        types[0] = new Type(1, "bottle", 0);
        types[0] = new Type(2, "can", 0);
        types[0] = new Type(3, "gable top", 0);
        types[0] = new Type(4, "glass", 0);
        types[0] = new Type(5, "juice box", 0);
        types[0] = new Type(6, "pouches", 0);
        types[0] = new Type(7, "bag in box", 0);
        types[0] = new Type(8, "alcohol", 0);
    }

    /**
     * return sample types
     *
     * @return array of type
     */
    public Type[] getTypes() {
        return types;
    }
}