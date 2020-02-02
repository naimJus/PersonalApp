package com.example.personalapp.ui.list;

import com.example.personalapp.data.Ticket;
import com.example.personalapp.repository.Repository;
import com.example.personalapp.repository.RepositoryImpl;

import java.util.List;

class ListPresenter implements ListContract.Presenter, TicketAdapter.ItemSelected {
    private final Repository mRepository;
    private final ListContract.View mView;
    private final TicketAdapter mTicketAdapter;

    ListPresenter(ListContract.View view, Repository repository, TicketAdapter ticketAdapter) {
        mView = view;
        mRepository = repository;
        mTicketAdapter = ticketAdapter;
    }

    @Override
    public void subscribe() {
        mView.showProgressBar(false);
        mRepository.getTickets(new RepositoryImpl.CompleteCallback() {
            @Override
            public void onSuccess(List<Ticket> list) {
                mView.hideProgressBar();
                mTicketAdapter.setDataSet(list);
                mTicketAdapter.setItemSelectedCallback(ListPresenter.this);
                mView.setAdapter(mTicketAdapter);
            }

            @Override
            public void onError(Throwable throwable) {
                mView.hideProgressBar();
                mView.showDefaultError();
            }
        });

    }

    @Override
    public void onItemSelected(Ticket ticket) {
        mView.openDetailsActivity(ticket);
    }
}
