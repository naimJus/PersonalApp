package com.example.personalapp.di;

import android.content.Context;

import com.example.personalapp.BuildConfig;
import com.example.personalapp.repository.Repository;
import com.example.personalapp.repository.RepositoryImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

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

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT);
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }

        builder.callTimeout(10L, TimeUnit.SECONDS);
        builder.readTimeout(10L, TimeUnit.SECONDS);
        builder.writeTimeout(10L, TimeUnit.SECONDS);
        return builder.build();
    }

    @Provides
    @Singleton
    Repository provideRepository(OkHttpClient okHttpClient, Realm realm) {
        return new RepositoryImpl(realm, okHttpClient);
    }
}
