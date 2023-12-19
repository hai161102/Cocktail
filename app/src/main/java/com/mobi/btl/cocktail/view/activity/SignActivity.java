package com.mobi.btl.cocktail.view.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mobi.btl.cocktail.App;
import com.mobi.btl.cocktail.R;
import com.mobi.btl.cocktail.base.BaseActivity;
import com.mobi.btl.cocktail.databinding.ActivitySignBinding;

public class SignActivity extends BaseActivity<ActivitySignBinding> {

    private enum MODE {
        SIGN_IN,
        SIGN_UP
    }
    private FirebaseAuth firebaseAuth;
    private MODE mode;
    @Override
    protected void initView() {
        switchMode(MODE.SIGN_IN);
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            App.getInstance().setFirebaseUser(firebaseAuth.getCurrentUser());
            this.startMain();
        }
    }

    private void startMain() {
        MainActivity.start(this);
        this.finish();
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void initData() {
        this.binding.btn2.setOnClickListener(v -> {
            if (this.mode.equals(MODE.SIGN_IN)) switchMode(MODE.SIGN_UP);
            else if (this.mode.equals(MODE.SIGN_UP)) switchMode(MODE.SIGN_IN);
        });

        this.binding.btn1.setOnClickListener(v -> {
            String email = this.binding.emailEdt.getText().toString().trim();
            String pass = this.binding.passEdt.getText().toString().trim();
            if (email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Không được để trống", Toast.LENGTH_LONG).show();
                return;
            }
            if (this.mode.equals(MODE.SIGN_IN)) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(
                        task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                                startMain();
                            }
                            else {
                                Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                );
            } else if (this.mode.equals(MODE.SIGN_UP)) {
                firebaseAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
                                startMain();
                            }
                            else {
                                Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });
    }

    private void switchMode(MODE mode) {
        if (mode.equals(MODE.SIGN_IN)) {
            this.binding.title.setText(R.string.sign_in);
            this.binding.btn1.setText(R.string.sign_in);
            this.binding.btn2.setText(R.string.sign_up);
            this.binding.btn1.setBackgroundTintList(
                    ColorStateList.valueOf(Color.parseColor("#00771D")));
        }
        else if (mode.equals(MODE.SIGN_UP)) {
            this.binding.title.setText(R.string.sign_up);
            this.binding.btn1.setText(R.string.sign_up);
            this.binding.btn2.setText(R.string.sign_in);
            this.binding.btn1.setBackgroundTintList(
                    ColorStateList.valueOf(getColor(R.color.app)));
        }
        this.mode = mode;
    }
    @Override
    protected int getLayoutID() {
        return R.layout.activity_sign;
    }
}
