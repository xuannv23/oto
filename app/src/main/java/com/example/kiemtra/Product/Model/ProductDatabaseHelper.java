package com.example.kiemtra.Product.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ProductDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="CarStore.db";

    public ProductDatabaseHelper(@Nullable Context context) {
        super(context, "CarStore.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists products");
    }


}
