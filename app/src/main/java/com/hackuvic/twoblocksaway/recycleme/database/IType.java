package com.hackuvic.twoblocksaway.recycleme.database;

/**
 * @author Jason, Tzu Hsiang Chen
 * @since March 11, 2018
 */
public interface IType {
    // place table name
    String TYPE_TABLE_NAME = "Types";

    // place column names
    String TYPE_ID_COLUMN = "itemId";
    String TYPE_NAME_COLUMN = "name";
    String TYPE_COUNT_COLUMN = "count";

    // create place table
    String CREATE_TYPE_TABLE = "CREATE TABLE " + TYPE_TABLE_NAME + "("
            + TYPE_ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TYPE_NAME_COLUMN + " TEXT, "
            + TYPE_COUNT_COLUMN + " INTEGER);";

    // drop place table
    String DROP_TYPE_TABLE = "DROP IF EXISTS " + TYPE_TABLE_NAME;
}
