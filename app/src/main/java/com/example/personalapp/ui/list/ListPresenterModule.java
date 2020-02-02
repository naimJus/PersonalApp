package com.example.personalapp.ui.list;

import com.example.personalapp.di.PerActivity;
import com.example.personalapp.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class ListPresenterModule {

    @PerActivity
    @Provides
    public ListContract.Presenter providePresenter(Repository repository) {
        return new ListPresenter(repository);
    }
}
