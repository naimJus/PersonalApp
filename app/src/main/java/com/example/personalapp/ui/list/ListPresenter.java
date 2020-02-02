package com.example.personalapp.ui.list;

import com.example.personalapp.repository.Repository;

class ListPresenter implements ListContract.Presenter {
    private final Repository mRepository;
    private final ListContract.View mView;

    ListPresenter(ListContract.View view, Repository repository) {
        mView = view;
        mRepository = repository;
    }
}
