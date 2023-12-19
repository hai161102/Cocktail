package com.mobi.btl.cocktail.view.holder;

import android.content.Context;

import androidx.annotation.NonNull;

import com.mobi.btl.cocktail.base.BaseHolder;
import com.mobi.btl.cocktail.databinding.LayoutInfoBinding;
import com.mobi.btl.cocktail.model.FormulaCocktail;

public class ItemFormHolder extends BaseHolder<LayoutInfoBinding, FormulaCocktail> {
    public ItemFormHolder(Context context, @NonNull LayoutInfoBinding binding) {
        super(context, binding);
    }

    @Override
    public void load(FormulaCocktail data) {
        this.binding.title.setText(data.getIngredient());
        this.binding.content.setText(data.getMeasure());
    }
}
