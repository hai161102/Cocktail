package com.mobi.btl.cocktail.view.dialog;

import android.content.Context;

import androidx.annotation.NonNull;

import com.mobi.btl.cocktail.R;
import com.mobi.btl.cocktail.databinding.DialogNotiBinding;


public class WarningDialog extends BaseDialog<DialogNotiBinding>{
    private static WarningDialog instance;
    public static WarningDialog getInstance(Context context) {
        if (WarningDialog.instance == null) WarningDialog.instance = new WarningDialog(context, null);
//        instance.message = mes;
        return instance;
    }

    public static WarningDialog getInstance() {
        return instance;
    }
    public WarningDialog(@NonNull Context context, OnActionDialogCallback onActionDialogCallback) {
        super(context, onActionDialogCallback);
    }


    @Override
    protected void addEvent() {
        binding.oke.setOnClickListener(v -> {
            dismiss();
        });
    }
    @Override
    protected void initView() {
    }

    @Override
    public void showDialog() {
        super.showDialog();
    }

    public void showMessage (String message) {
        showDialog();
        binding.message.setText(message);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_noti;
    }

}
