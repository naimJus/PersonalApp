package com.example.personalapp.di;

import android.content.Context;

import com.example.personalapp.repository.Repository;
import com.example.personalapp.repository.RepositoryImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import okhttp3.OkHttpClient;

@Module
public class AppModule {

    private final Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext.getApplicationContext();
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new GsonBuilder().create();
    }


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder.build();
    }


    @Provides
    @Singleton
    Repository provideRepository(OkHttpClient okHttpClient) {
        return new RepositoryImpl(okHttpClient);
    }

    @Provides
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }
}
