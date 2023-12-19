package com.mobi.btl.cocktail.view.activity;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.Nullable;

import com.mobi.btl.cocktail.R;
import com.mobi.btl.cocktail.api.result.Cocktail;
import com.mobi.btl.cocktail.base.BaseActivity;
import com.mobi.btl.cocktail.databinding.ActivityFavoriteBinding;
import com.mobi.btl.cocktail.room.database.MyDatabase;
import com.mobi.btl.cocktail.utils.AppUtils;
import com.mobi.btl.cocktail.view.adapter.CocktailAdapter;

public class FavoriteActivity extends BaseActivity<ActivityFavoriteBinding> {

    private CocktailAdapter cocktailAdapter;

    public static void start(Context context) {
        Intent starter = new Intent(context, FavoriteActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void initView() {
        cocktailAdapter = new CocktailAdapter(this);
        this.binding.listSearch.setAdapter(cocktailAdapter);
        cocktailAdapter.addMulti(AppUtils.convertCocktails(MyDatabase.getInstance().getFavorite().getAll()), true);
    }

    @Override
    protected void initData() {
        this.binding.back.setOnClickListener(v -> finish());
        this.cocktailAdapter.setOnItemClickListener(cocktail -> {
            InfoActivity.start(this, cocktail.getIdDrink());
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
        return R.layout.activity_favorite;
    }
}
