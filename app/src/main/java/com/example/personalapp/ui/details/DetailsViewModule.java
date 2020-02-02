package com.example.personalapp.ui.details;

import com.example.personalapp.di.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailsViewModule {

    private DetailsContract.View mView;

    public DetailsViewModule(DetailsContract.View view) {
        mView = view;
    }

    @Provides
    @PerActivity
    DetailsContract.View provideView() {
        return mView;
    }
}
