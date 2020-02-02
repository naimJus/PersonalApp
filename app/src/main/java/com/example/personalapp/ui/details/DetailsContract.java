package com.example.personalapp.ui.details;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.example.personalapp.ui.BaseView;

public interface DetailsContract {
    interface View extends BaseView {

        void setTourName(String artistTourName);

        void setArtistName(String artistName);

        void setArtistPoster(String artistImage);

        void setEventTime(String eventTime);

        void setEventDate(String eventDate);

        void setFavoriteIcon(MenuItem menuItem, @DrawableRes int imgRes);
    }

    interface Presenter {
        void subscribe(@Nullable Bundle bundle);

        void manageFavorite(MenuItem menuItem);

        void subscribeMenu(MenuItem menuItem);
    }
}
