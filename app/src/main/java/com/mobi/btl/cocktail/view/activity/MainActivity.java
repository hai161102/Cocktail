package com.mobi.btl.cocktail.view.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.mobi.btl.cocktail.R;
import com.mobi.btl.cocktail.api.ApiConfigs;
import com.mobi.btl.cocktail.api.result.Cocktail;
import com.mobi.btl.cocktail.api.result.DataFilter;
import com.mobi.btl.cocktail.api.result.Results;
import com.mobi.btl.cocktail.base.BaseActivity;
import com.mobi.btl.cocktail.databinding.ActivityMainBinding;
import com.mobi.btl.cocktail.interfaces.OnItemClickListener;
import com.mobi.btl.cocktail.utils.LoadDataUtils;
import com.mobi.btl.cocktail.view.adapter.CocktailAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("unchecked")
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private CocktailAdapter cocktailAdapter;
    private final List<Cocktail> list = new ArrayList<>();

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void initView() {
        cocktailAdapter = new CocktailAdapter(this);
        this.binding.listSearch.setAdapter(cocktailAdapter);
        this.updateUI();
    }

    private void updateUI() {
        binding.listSearch.setVisibility(View.GONE);
        binding.loadingView.setVisibility(View.VISIBLE);
        if (list.size() > 0) {
            cocktailAdapter.addMulti(list, true);
            binding.loadingView.setVisibility(View.GONE);
            binding.listSearch.setVisibility(View.VISIBLE);
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("c", "Cocktail");
        ApiConfigs.getInstance().apiServices.filter(map)
                .enqueue(new Callback<Results<DataFilter>>() {
                    @Override
                    public void onResponse(@NonNull Call<Results<DataFilter>> call, @NonNull Response<Results<DataFilter>> response) {
                        if (response.isSuccessful() && response.body() != null && response.body().getDrinks() != null) {
                            new LoadDataUtils(new LoadDataUtils.LoadListener() {
                                @Override
                                public void onDone(List<Cocktail> list) {
//                                    MainActivity.this.list.addAll(list);
//                                    cocktailAdapter.addMulti(list, true);
//                                    binding.loadingView.setVisibility(View.GONE);
//                                    binding.listSearch.setVisibility(View.VISIBLE);
//                                    System.out.println("Load list done");
                                }

                                @Override
                                public void onUpdate(Cocktail cocktail) {
                                    MainActivity.this.list.add(cocktail);
                                    cocktailAdapter.add(cocktail);
                                    binding.loadingView.setVisibility(View.GONE);
                                    binding.listSearch.setVisibility(View.VISIBLE);
                                    System.out.println("Load list done");
                                }
                            }).execute(response.body().getDrinks());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Results<DataFilter>> call, @NonNull Throwable t) {
                    }
                });
    }


    @Override
    protected void initData() {
        this.binding.listBtn.setOnClickListener(v -> {
            FavoriteActivity.start(this);
        });
        this.cocktailAdapter.setOnItemClickListener(cocktail -> {
            InfoActivity.start(this, cocktail.getIdDrink());
        });
        this.binding.search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <= 0) {
                    updateUI();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    binding.listSearch.setVisibility(View.GONE);
                    binding.loadingView.setVisibility(View.VISIBLE);
                    ApiConfigs.getInstance().apiServices.searchByName(s.toString()).enqueue(new Callback<Results<Cocktail>>() {
                        @Override
                        public void onResponse(@NonNull Call<Results<Cocktail>> call, @NonNull Response<Results<Cocktail>> response) {
                            if (response.isSuccessful() && response.body() != null && response.body().getDrinks() != null) {
                                cocktailAdapter.addMulti(response.body().getDrinks(), true);
                                binding.loadingView.setVisibility(View.GONE);
                                binding.listSearch.setVisibility(View.VISIBLE);
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<Results<Cocktail>> call, @NonNull Throwable t) {
                            Log.d("TAG_Main", "onFailure: " + t.getMessage());
                        }
                    });
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == InfoActivity.REQUEST_CODE) {
                if (data != null) {
                    String id = data.getStringExtra("data");
                    if (id == null) return;
                    for (Cocktail cocktail : cocktailAdapter.getList()) {
                        if (cocktail.getIdDrink().equals(id)) {
                            cocktailAdapter.notifyItemChanged(
                                    cocktailAdapter.getList().indexOf(cocktail)
                            );
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }


}