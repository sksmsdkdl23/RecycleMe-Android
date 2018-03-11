package com.hackuvic.twoblocksaway.recycleme.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hackuvic.twoblocksaway.recycleme.model.Type;

/**
 * @author Jason, Tzu Hsiang Chen
 * @since March 11, 2018
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName();
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "recycleme.db";
    // Create helper instance
    private static DatabaseHelper instance;

    /**
     * DatabaseHelper constructor
     *
     * @param context - current context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Start database instance.
     *
     * @param context - current context.
     * @return databaseHelper - current instance.
     */
    public static synchronized DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    /**
     * Create tables in SQLite database
     *
     * @param sqLiteDatabase - SQLiteDatabase object
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i(TAG, "Create SQLite database version " + DATABASE_VERSION);
        try {
            sqLiteDatabase.execSQL(IType.CREATE_TYPE_TABLE);
            Type[] types = new TypeSeed().getTypes();
            for (Type type : types) {
                insertSampleEvents(sqLiteDatabase, type);
            }
        } catch (SQLiteException e) {
            Log.e(TAG, "Cannot create table - " + e.getMessage());
        }
    }

    /**
     * Upgrade tables in SQLite database
     *
     * @param sqLiteDatabase - SQLiteDatabase object
     * @param oldVersion     - current version in the device
     * @param newVersion     - updated version
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            Log.i(TAG, "Upgrade SQLite database from version " + oldVersion + " to version " + newVersion);
            try {
                sqLiteDatabase.execSQL(IType.DROP_TYPE_TABLE);
                this.onCreate(sqLiteDatabase);
            } catch (SQLiteException e) {
                Log.e(TAG, "Cannot upgrade table - " + e.getMessage());
            }
        }
    }

    /**
     * Insert type samples.
     *
     * @param sqLiteDatabase - SQLite connection.
     * @param type           - type object.
     */
    private void insertSampleEvents(SQLiteDatabase sqLiteDatabase, Type type) {
        ContentValues values = new ContentValues();
        values.put(IType.TYPE_ID_COLUMN, type.getId());
        values.put(IType.TYPE_NAME_COLUMN, type.getName());
        values.put(IType.TYPE_COUNT_COLUMN, type.getCount());

        long result = sqLiteDatabase.insert(IType.TYPE_TABLE_NAME, null, values);
        Log.d(TAG, "insert sample type " + result + " row");
    }
}
