package com.mobi.btl.cocktail.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.mobi.btl.cocktail.model.CocktailModel;

import java.util.List;

@Dao
public interface CocktailDao {
    @Query("select * from CocktailModel")
    List<CocktailModel> getAll();
    @Query("select * from CocktailModel where idDrink= :id")
    CocktailModel get(String id);
    @Insert
    void insert(CocktailModel cocktailModel);
    @Delete
    void delete(CocktailModel cocktailModel);
}
