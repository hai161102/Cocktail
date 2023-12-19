package com.mobi.btl.cocktail.api.result;

import java.io.Serializable;
import java.lang.String;

public class DataFilter implements Serializable {
  private String strDrink;

  private String strDrinkThumb;

  private String idDrink;

  public String getStrDrink() {
    return this.strDrink;
  }

  public void setStrDrink(String strDrink) {
    this.strDrink = strDrink;
  }

  public String getStrDrinkThumb() {
    return this.strDrinkThumb;
  }

  public void setStrDrinkThumb(String strDrinkThumb) {
    this.strDrinkThumb = strDrinkThumb;
  }

  public String getIdDrink() {
    return this.idDrink;
  }

  public void setIdDrink(String idDrink) {
    this.idDrink = idDrink;
  }
}
