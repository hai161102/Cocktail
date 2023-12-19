package com.mobi.btl.cocktail.api.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Results<T> implements Serializable {
    private List<T> drinks = new ArrayList<>();

    public List<T> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<T> drinks) {
        this.drinks = drinks;
    }
}
