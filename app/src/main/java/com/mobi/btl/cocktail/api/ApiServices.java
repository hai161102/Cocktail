package com.mobi.btl.cocktail.api;

import com.mobi.btl.cocktail.api.result.Cocktail;
import com.mobi.btl.cocktail.api.result.DataFilter;
import com.mobi.btl.cocktail.api.result.Results;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiServices {
    @GET("api/json/v1/1/search.php")
    Call<Results<Cocktail>> searchByName(@Query("s") String s);
    @GET("api/json/v1/1/search.php")
    Call<Results<Cocktail>> searchByFirstLetter(@Query("f") String f);
    @GET("api/json/v1/1/lookup.php")
    Call<Results<Cocktail>> getById(@Query("i") String id);
    @GET("api/json/v1/1/random.php")
    Call<Results<Cocktail>> random();
    @GET("api/json/v1/1/list.php/{type}=list")
    Call<Results<String>> listCategories(@Path("type") String type);
    @GET("api/json/v1/1/filter.php")
    Call<Results<DataFilter>> filter(@QueryMap Map<String, String> options);
}
