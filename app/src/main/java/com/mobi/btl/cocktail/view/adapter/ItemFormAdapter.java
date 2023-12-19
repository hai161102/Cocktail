package com.mobi.btl.cocktail.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.mobi.btl.cocktail.R;
import com.mobi.btl.cocktail.base.BaseAdapter;
import com.mobi.btl.cocktail.databinding.LayoutInfoBinding;
import com.mobi.btl.cocktail.model.FormulaCocktail;
import com.mobi.btl.cocktail.view.holder.ItemFormHolder;

public class ItemFormAdapter extends BaseAdapter<FormulaCocktail, LayoutInfoBinding, ItemFormHolder> {
    public ItemFormAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_info;
    }

    @NonNull
    @Override
    public ItemFormHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemFormHolder(
                this.context,
                DataBindingUtil.inflate(
                        LayoutInflater.from(this.context),
                        getLayoutId(),
                        parent,
                        false
                )
        );
    }
}
