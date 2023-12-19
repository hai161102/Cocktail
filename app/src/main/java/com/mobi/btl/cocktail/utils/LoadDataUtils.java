package com.mobi.btl.cocktail.utils;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

import com.mobi.btl.cocktail.api.ApiConfigs;
import com.mobi.btl.cocktail.api.result.Cocktail;
import com.mobi.btl.cocktail.api.result.DataFilter;
import com.mobi.btl.cocktail.api.result.Results;
import com.mobi.btl.cocktail.view.activity.MainActivity;

import org.jetbrains.annotations.Async;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoadDataUtils extends AsyncTask<List<DataFilter>, Void, List<Cocktail>> {

    private final List<Cocktail> list = new ArrayList<>();
    private LoadListener listener;

    public LoadDataUtils(LoadListener listener) {
        this.listener = listener;
    }

    @Override
    protected List<Cocktail> doInBackground(List<DataFilter>... lists) {
        loadData(lists[0], 0, new LoadListener() {
            @Override
            public void onDone(List<Cocktail> list) {
                listener.onDone(list);
            }

            @Override
            public void onUpdate(Cocktail cocktail) {
                listener.onUpdate(cocktail);
            }
        });
        return list;
    }
    @Async.Schedule
    private void loadData(@NonNull List<DataFilter> dataFilters, int count, LoadListener loadListener) {
        if (count >= dataFilters.size()) {
            loadListener.onDone(list);
            return;
        }
        ApiConfigs.getInstance().apiServices.getById(dataFilters.get(count).getIdDrink())
                .enqueue(new Callback<Results<Cocktail>>() {
                    @Override
                    public void onResponse(@NonNull Call<Results<Cocktail>> call, @NonNull Response<Results<Cocktail>> response) {
                        if (response.isSuccessful() && response.body() != null && response.body().getDrinks() != null) {
                            list.addAll(response.body().getDrinks());
                            loadListener.onUpdate(response.body().getDrinks().get(0));
                        }
                        loadData(dataFilters, count + 1, loadListener);
                    }

                    @Override
                    public void onFailure(@NonNull Call<Results<Cocktail>> call, Throwable t) {
                        loadData(dataFilters, count + 1, loadListener);
                    }
                });
    }
    @Override
    protected void onPostExecute(List<Cocktail> cocktails) {
        super.onPostExecute(cocktails);
    }
    public interface LoadListener{
        void onDone(List<Cocktail> list);
        void onUpdate(Cocktail cocktail);
    }
}
