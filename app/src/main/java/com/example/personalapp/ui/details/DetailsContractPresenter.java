package com.example.personalapp.ui.details;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.personalapp.R;
import com.example.personalapp.data.Ticket;
import com.example.personalapp.repository.Repository;

class DetailsContractPresenter implements DetailsContract.Presenter {

    private final DetailsContract.View mView;
    private final Repository mRepository;
    private Ticket mTicket;

    public DetailsContractPresenter(DetailsContract.View view, Repository repository) {
        mView = view;
        mRepository = repository;
    }

    @Override
    public void subscribe(Bundle bundle) {
        mTicket = bundle.getParcelable(DetailsActivity.TICKET_EXTRA);
        if (mTicket == null) {
            mView.showDefaultError();
            return;
        }

        populateUi();
    }

    private void populateUi() {
        mView.setTourName(mTicket.getArtistTourName());
        mView.setArtistName(mTicket.getArtistName());
        mView.setArtistPoster(mTicket.getArtistImage());
        mView.setEventTime(mTicket.getEventTime());
        mView.setEventDate(mTicket.getEventDate());
        mView.setArtistPopularity(mTicket.getArtiestPopularity());
        mView.setVenueName(mTicket.getVenueName());
        mView.setVenueCity(mTicket.getVenueCity());
        mView.setVenueZipCode(mTicket.getVenueZipcode());
        mView.setVenueStreet(mTicket.getVenueStreet());
        mView.setVenueBuildingNumber(mTicket.getVenuebuildingNumber());
    }

    @Override
    public void manageFavorite(MenuItem item) {
        mRepository.setFavorite(!mTicket.isFavorite(), mTicket);
        subscribeMenu(item);
    }

    @Override
    public void subscribeMenu(MenuItem menuItem) {
        if (mTicket.isFavorite()) {
            mView.setFavoriteIcon(menuItem, R.drawable.ic_favorite);
        } else {
            mView.setFavoriteIcon(menuItem, R.drawable.ic_favorite_false);
        }
    }

    @Override
    public void tourNameChanged(CharSequence tourName) {
        mRepository.setTourName(tourName.toString(), mTicket);
    }
}
