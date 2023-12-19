package com.mobi.btl.cocktail.view.holder;

import static com.mobi.btl.cocktail.utils.AppUtils.getTextProperty;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.mobi.btl.cocktail.R;
import com.mobi.btl.cocktail.api.result.Cocktail;
import com.mobi.btl.cocktail.base.BaseHolder;
import com.mobi.btl.cocktail.databinding.ItemCocktailBinding;
import com.mobi.btl.cocktail.interfaces.OnItemClickListener;
import com.mobi.btl.cocktail.model.CocktailModel;
import com.mobi.btl.cocktail.room.database.MyDatabase;
import com.mobi.btl.cocktail.utils.AppUtils;
import com.mobi.btl.cocktail.view.activity.InfoActivity;

public class CocktailHolder extends BaseHolder<ItemCocktailBinding, Cocktail> {

    private OnItemClickListener onItemClickListener;
    public CocktailHolder(Context context, @NonNull ItemCocktailBinding binding) {
        super(context, binding);
    }

    public CocktailHolder setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        return this;
    }

    @Override
    public void load(Cocktail data) {

        CocktailModel cocktailModel = MyDatabase.getInstance().getFavorite().get(data.getIdDrink());
        if (cocktailModel != null) {
            this.binding.addFvr.setImageResource(R.drawable.ic_favorited);
        }
        else {
            this.binding.addFvr.setImageResource(R.drawable.ic_not_favorite);
        }

        this.binding.title.setText(getTextProperty(data.getStrDrink()));
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
            Glide.with(this.context).load(data.getStrDrinkThumb()).into(this.binding.thumb);
        }

        this.binding.addFvr.setOnClickListener(v-> {
            if (cocktailModel == null) {
                MyDatabase.getInstance().getFavorite().insert(AppUtils.convertCocktailModel(data));
            }
            else {
                MyDatabase.getInstance().getFavorite().delete(cocktailModel);
            }
            this.getAdapter().notifyItemChanged(getAdapterPosition());

        });
        this.binding.info.setOnClickListener(v -> {
           if (this.onItemClickListener != null) this.onItemClickListener.onClick(data);
        });
    }
}
