package com.mobi.btl.cocktail.view.activity;

import static com.mobi.btl.cocktail.utils.AppUtils.getTextProperty;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.mobi.btl.cocktail.R;
import com.mobi.btl.cocktail.api.ApiConfigs;
import com.mobi.btl.cocktail.api.result.Cocktail;
import com.mobi.btl.cocktail.api.result.Results;
import com.mobi.btl.cocktail.base.BaseActivity;
import com.mobi.btl.cocktail.databinding.ActivityInfomationBinding;
import com.mobi.btl.cocktail.model.CocktailModel;
import com.mobi.btl.cocktail.room.database.MyDatabase;
import com.mobi.btl.cocktail.utils.AppUtils;
import com.mobi.btl.cocktail.view.adapter.ItemFormAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoActivity extends BaseActivity<ActivityInfomationBinding> {

    public final static String ID = "ID";
    public final static int REQUEST_CODE = 104;
    private Cocktail cocktail;
    private ItemFormAdapter itemFormAdapter;

//    public static void start(Context context, String drinkId) {
//        Intent starter = new Intent(context, InfoActivity.class);
//        starter.putExtra(InfoActivity.ID, drinkId);
//        context.startActivity(starter);
//    }

    public static void start(Activity context, String drinkId) {
        Intent starter = new Intent(context, InfoActivity.class);
        starter.putExtra(InfoActivity.ID, drinkId);
        context.startActivityForResult(starter, REQUEST_CODE);
    }
    @Override
    protected void initView() {
        itemFormAdapter = new ItemFormAdapter(this);
        this.binding.formRcv.setAdapter(itemFormAdapter);
        String drinkId = getIntent().getStringExtra(InfoActivity.ID);
        if (drinkId != null) {
            ApiConfigs.getInstance().apiServices.getById(drinkId)
                    .enqueue(new Callback<Results<Cocktail>>() {
                        @Override
                        public void onResponse(@NonNull Call<Results<Cocktail>> call, @NonNull Response<Results<Cocktail>> response) {
                            if (response.isSuccessful()
                                    && response.body() != null
                                    && response.body().getDrinks() != null) {
                                updateUI(response.body().getDrinks().get(0));
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<Results<Cocktail>> call, @NonNull Throwable t) {

                        }
                    });
        }
    }

    private void updateUI(Cocktail data) {
        this.cocktail = data;
        this.binding.nameCocktail.setText(data.getStrDrink());
        this.binding.tagData.title.setText("TAG: ");
        this.binding.tagData.content.setText(getTextProperty(data.getStrTags()));

        this.binding.category.title.setText("Category: ");
        this.binding.category.content.setText(getTextProperty(data.getStrCategory()));

        this.binding.alcoholic.title.setText("Alcoholic: ");
        this.binding.alcoholic.content.setText(getTextProperty(data.getStrAlcoholic()));

        this.binding.iba.title.setText("IBA: ");
        this.binding.iba.content.setText(getTextProperty(data.getStrIBA()));

        this.binding.glass.title.setText("Glass: ");
        this.binding.glass.content.setText(getTextProperty(data.getStrGlass()));

        this.binding.instructions.title.setText("Instructions: ");
        this.binding.instructions.content.setText(getTextProperty(data.getStrInstructions()));

        this.binding.banquyen.title.setText("Creative Commons Confirmed: ");
        this.binding.banquyen.content.setText(getTextProperty(data.getStrCreativeCommonsConfirmed()));

        if (data.getStrDrinkThumb() != null) {
            Glide.with(this).load(data.getStrDrinkThumb()).into(this.binding.thumb);
        }
        updateFavorite(data);
        this.binding.addFvr.setOnClickListener(v-> {
            CocktailModel cocktailModel = MyDatabase.getInstance().getFavorite().get(data.getIdDrink());
            if (cocktailModel == null) {
                MyDatabase.getInstance().getFavorite().insert(AppUtils.convertCocktailModel(data));
            }
            else {
                MyDatabase.getInstance().getFavorite().delete(cocktailModel);
            }
            this.updateFavorite(data);
        });
        itemFormAdapter.addMulti(AppUtils.getFormulaList(data), true);

    }

    private void updateFavorite(Cocktail data) {
        CocktailModel cocktailModel = MyDatabase.getInstance().getFavorite().get(data.getIdDrink());
        if (cocktailModel != null) {
            this.binding.addFvr.setImageResource(R.drawable.ic_favorited);
        }
        else {
            this.binding.addFvr.setImageResource(R.drawable.ic_not_favorite);
        }
    }

    @Override
    protected void initData() {
        this.binding.back.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("data", cocktail.getIdDrink());
            this.setResult(RESULT_OK, intent);
            finish();
        });
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_infomation;
    }
}
