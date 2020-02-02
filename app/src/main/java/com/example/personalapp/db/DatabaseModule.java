package com.example.personalapp.db;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class DatabaseModule {

    @Provides
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }
}
