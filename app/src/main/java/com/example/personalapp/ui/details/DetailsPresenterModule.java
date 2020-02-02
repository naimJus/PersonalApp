package com.example.personalapp.ui.details;

import com.example.personalapp.di.PerActivity;
import com.example.personalapp.repository.Repository;
import com.example.personalapp.ui.list.TicketAdapter;

import dagger.Module;
import dagger.Provides;

@Module
class DetailsPresenterModule {

    @PerActivity
    @Provides
    DetailsContract.Presenter providePresenter(DetailsContract.View view, Repository repository) {
        return new DetailsContractPresenter(view, repository);
    }
}
