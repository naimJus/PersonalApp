package com.example.personalapp.ui.list;

import android.view.MenuItem;

import com.example.personalapp.R;
import com.example.personalapp.data.Ticket;
import com.example.personalapp.repository.Repository;
import com.example.personalapp.repository.RepositoryImpl;

import java.util.List;

class ListPresenter implements ListContract.Presenter, TicketAdapter.ItemSelected {
    private final Repository mRepository;
    private final ListContract.View mView;
    private final TicketAdapter mTicketAdapter;
    private boolean isShowAll = true;

    ListPresenter(ListContract.View view, Repository repository, TicketAdapter ticketAdapter) {
        mView = view;
        mRepository = repository;
        mTicketAdapter = ticketAdapter;
    }

    @Override
    public void subscribe() {
        mView.setAdapter(mTicketAdapter);

        mView.showProgressBar(false);

        mRepository.getTickets(new RepositoryImpl.CompleteCallback() {
            @Override
            public void onSuccess(List<Ticket> list) {
                mView.hideProgressBar();
                mTicketAdapter.setDataSet(list);
                mTicketAdapter.notifyDataSetChanged();
                mTicketAdapter.setItemSelectedCallback(ListPresenter.this);
            }

            @Override
            public void onError(Throwable throwable) {
                mView.hideProgressBar();
                mView.showDefaultError();
            }
        });
    }

    @Override
    public void changeList(MenuItem item) {
        mView.showProgressBar(false);

        RepositoryImpl.CompleteCallback completeCallback = new RepositoryImpl.CompleteCallback() {
            @Override
            public void onSuccess(List<Ticket> list) {
                mView.hideProgressBar();
                mTicketAdapter.setDataSet(list);
                mTicketAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable throwable) {
                mView.hideProgressBar();
                mView.showDefaultError();
            }
        };

        if (isShowAll) {
            mRepository.getFavoriteTickets(completeCallback);
            item.setTitle(R.string.show_all);
            isShowAll = false;
        } else {
            mRepository.getTickets(completeCallback);
            item.setTitle(R.string.show_favorites);
            isShowAll = true;
        }
    }

    @Override
    public void onItemSelected(Ticket ticket) {
        mView.openDetailsActivity(ticket);
    }
}
