package com.mobi.btl.cocktail.room.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mobi.btl.cocktail.model.CocktailModel;
import com.mobi.btl.cocktail.room.dao.CocktailDao;

@androidx.room.Database(entities = {CocktailModel.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    private static MyDatabase instance;

    public static MyDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context,
                    MyDatabase.class,
                    "Cocktail"

            ).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public static MyDatabase getInstance() {
        return instance;
    }

    public abstract CocktailDao getFavorite();
}
