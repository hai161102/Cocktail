package com.mobi.btl.cocktail.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.mobi.btl.cocktail.R;
import com.mobi.btl.cocktail.api.result.Cocktail;
import com.mobi.btl.cocktail.base.BaseAdapter;
import com.mobi.btl.cocktail.databinding.ItemCocktailBinding;
import com.mobi.btl.cocktail.interfaces.OnItemClickListener;
import com.mobi.btl.cocktail.view.holder.CocktailHolder;

public class CocktailAdapter extends BaseAdapter<Cocktail, ItemCocktailBinding, CocktailHolder> {
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public CocktailAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_cocktail;
    }

    @NonNull
    @Override
    public CocktailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CocktailHolder(
                this.context,
                DataBindingUtil.inflate(
                        LayoutInflater.from(this.context),
                        this.getLayoutId(),
                        parent,
                        false
                )
        ).setOnItemClickListener(cocktail -> {
            if (this.onItemClickListener != null) {
                this.onItemClickListener.onClick(cocktail);
            }
        });
    }
}
