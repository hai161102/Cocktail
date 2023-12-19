package com.mobi.btl.cocktail.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfigs {
    private static ApiConfigs instance;
    public static final String BASE_URL = "https://www.thecocktaildb.com/";

    public Retrofit retrofit;
    public ApiServices apiServices;
    public static ApiConfigs getInstance() {
        if (ApiConfigs.instance == null) ApiConfigs.instance = new ApiConfigs();
        return instance;
    }

    private ApiConfigs() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.apiServices = this.retrofit.create(ApiServices.class);
    }
}
