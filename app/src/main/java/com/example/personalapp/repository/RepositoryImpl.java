package com.example.personalapp.repository;

import io.realm.Realm;
import okhttp3.OkHttpClient;

public class RepositoryImpl implements Repository {
    private final Realm mRealm;
    private final OkHttpClient mOkHttpClient;

    public RepositoryImpl(Realm realm, OkHttpClient okHttpClient) {
        mRealm = realm;
        mOkHttpClient = okHttpClient;
    }
}
