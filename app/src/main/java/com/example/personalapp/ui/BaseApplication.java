package com.example.personalapp.ui;

import android.app.Application;

import com.example.personalapp.di.AppComponent;
import com.example.personalapp.di.DaggerAppComponent;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BaseApplication extends Application {

    public static final String DB_NAME = "personal.db";
    public static final int SCHEMA_VERSION = 1;

    private static AppComponent sComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initDb();

        initDagger();
    }

    private void initDb() {
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(DB_NAME)
                .schemaVersion(SCHEMA_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private void initDagger() {
        sComponent = DaggerAppComponent.builder().build();
        sComponent.inject(this);
    }

    public static AppComponent getComponent() {
        return sComponent;
    }

}
