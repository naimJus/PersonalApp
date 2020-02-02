package com.example.personalapp.ui.details;

import com.example.personalapp.di.AppComponent;
import com.example.personalapp.di.PerActivity;

import dagger.Component;

@PerActivity
@Component(modules = {DetailsViewModule.class, DetailsPresenterModule.class},
        dependencies = {AppComponent.class})
public interface DetailsComponent {

    void inject(DetailsActivity inject);
}
