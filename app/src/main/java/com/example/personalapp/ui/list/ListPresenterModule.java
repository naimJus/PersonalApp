package com.example.personalapp.ui.list;

import com.example.personalapp.di.PerActivity;
import com.example.personalapp.repository.Repository;

import dagger.Module;
import dagger.Provides;

@Module
class ListPresenterModule {

    @PerActivity
    @Provides
    TicketAdapter provideTicketAdapter() {
        return new TicketAdapter();
    }

    @PerActivity
    @Provides
    ListContract.Presenter providePresenter(ListContract.View view, Repository repository, TicketAdapter ticketAdapter) {
        return new ListPresenter(view, repository, ticketAdapter);
    }
}
