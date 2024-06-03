package com.example.config;

import org.mapdb.DB;
import org.mapdb.DBMaker;

public class DatabaseConfig {
    private static final String NOTES_MAPDB = "notes.mapdb";

    public static DB getDatabase() {
        return DBMaker.fileDB(NOTES_MAPDB).make();
    }

    public static DB getMemoryDatabase() {
        return DBMaker.memoryDB().make();
    }
}