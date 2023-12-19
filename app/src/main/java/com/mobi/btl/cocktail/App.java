package com.mobi.btl.cocktail;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.mobi.btl.cocktail.api.ApiConfigs;
import com.mobi.btl.cocktail.room.database.MyDatabase;

public class App extends Application {
    private static App instance;

    public static App getInstance() {
        return instance;
    }

    private FirebaseUser firebaseUser;

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    public void setFirebaseUser(FirebaseUser firebaseUser) {
        this.firebaseUser = firebaseUser;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        App.instance = this;
        ApiConfigs.getInstance();
        MyDatabase.getInstance(getApplicationContext());
        FirebaseApp.initializeApp(this.getApplicationContext());

    }
}
