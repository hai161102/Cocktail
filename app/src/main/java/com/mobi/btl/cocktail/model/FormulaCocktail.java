package com.mobi.btl.cocktail.model;

public class FormulaCocktail {
    private String ingredient;
    private String measure;

    public FormulaCocktail(String ingredient, String measure) {
        this.ingredient = ingredient;
        this.measure = measure;
    }

    public FormulaCocktail() {
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
