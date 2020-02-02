package com.example.personalapp.di;

import com.example.personalapp.repository.Repository;
import com.example.personalapp.ui.BaseApplication;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(BaseApplication inject);

    Realm provideRealm();

    Repository provideRepository();
}
