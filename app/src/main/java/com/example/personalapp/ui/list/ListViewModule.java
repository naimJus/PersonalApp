package com.example.personalapp.ui.list;

import com.example.personalapp.di.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ListViewModule {

    private ListContract.View mView;

    public ListViewModule(ListContract.View view) {
        mView = view;
    }

    @Provides
    @PerActivity
    ListContract.View provideView() {
        return mView;
    }
}
