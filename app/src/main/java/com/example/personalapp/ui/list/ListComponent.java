package com.example.personalapp.ui.list;

import com.example.personalapp.di.AppComponent;
import com.example.personalapp.di.PerActivity;

import dagger.Component;

@PerActivity
@Component(modules = {ListViewModule.class, ListPresenterModule.class},
        dependencies = {AppComponent.class})
public interface ListComponent {

    void inject(ListActivity inject);
}
