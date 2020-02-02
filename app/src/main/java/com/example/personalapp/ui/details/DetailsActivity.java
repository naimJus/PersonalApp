package com.example.personalapp.ui.details;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.personalapp.R;
import com.example.personalapp.ui.BaseActivity;
import com.example.personalapp.ui.BaseApplication;
import com.facebook.drawee.view.SimpleDraweeView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class DetailsActivity extends BaseActivity implements DetailsContract.View {

    public static final String TICKET_EXTRA = DetailsActivity.class.getSimpleName() + "ticket_extra";

    @BindView(R.id.poster_drawee)
    SimpleDraweeView mPosterDraweeView;
    @BindView(R.id.tour_name_edit_text)
    EditText mTourNameEditText;
    @BindView(R.id.artist_name_text)
    TextView mArtistNameTextView;
    @BindView(R.id.event_date_text_view)
    TextView mEventDateTextView;
    @BindView(R.id.event_time_text_view)
    TextView mEventTimeTextView;

    @BindView(R.id.artist_popularity)
    TextView mArtistPopularity;
    @BindView(R.id.venue_country)
    TextView mVenueCountry;
    @BindView(R.id.venue_name)
    TextView mVenueName;
    @BindView(R.id.venue_city)
    TextView mVenueCity;
    @BindView(R.id.venue_zipcode)
    TextView mVenueZipCode;
    @BindView(R.id.venue_street)
    TextView mVenueStreet;
    @BindView(R.id.venue_building_number)
    TextView mVenueBuildingNumber;


    @Inject
    DetailsContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        initDagger();

        mPresenter.subscribe(getIntent().getExtras());
    }

    private void initDagger() {
        DaggerDetailsComponent.builder()
                .appComponent(BaseApplication.getComponent())
                .detailsPresenterModule(new DetailsPresenterModule())
                .detailsViewModule(new DetailsViewModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void setTourName(String artistTourName) {
        if (!TextUtils.isEmpty(artistTourName)) {
            mTourNameEditText.setText(artistTourName);
        }
    }

    @Override
    public void setArtistName(String artistName) {
        if (!TextUtils.isEmpty(artistName)) {
            mArtistNameTextView.setText(artistName);
        }
    }

    @Override
    public void setArtistPoster(String artistImage) {
        if (!TextUtils.isEmpty(artistImage)) {
            mPosterDraweeView.setImageURI(Uri.parse(artistImage));
        }
    }

    @Override
    public void setEventTime(String eventTime) {
        if (!TextUtils.isEmpty(eventTime)) {
            mEventTimeTextView.setText(eventTime);
        }
    }

    @Override
    public void setEventDate(String eventDate) {
        if (!TextUtils.isEmpty(eventDate)) {
            mEventDateTextView.setText(eventDate);
        }
    }

    @Override
    public void setFavoriteIcon(MenuItem menuItem, int imgRes) {
        menuItem.setIcon(imgRes);
    }

    @Override
    public void setVenueBuildingNumber(String venuebuildingNumber) {
        if (!TextUtils.isEmpty(venuebuildingNumber)) {
            mVenueBuildingNumber.setText(venuebuildingNumber);
        }
    }

    @Override
    public void setVenueStreet(String venueStreet) {
        if (!TextUtils.isEmpty(venueStreet)) {
            mVenueStreet.setText(venueStreet);
        }
    }

    @Override
    public void setVenueZipCode(String venueZipcode) {
        if (!TextUtils.isEmpty(venueZipcode)) {
            mVenueZipCode.setText(venueZipcode);
        }
    }

    @Override
    public void setVenueCity(String venueCity) {
        if (!TextUtils.isEmpty(venueCity)) {
            mVenueCity.setText(venueCity);
        }
    }

    @Override
    public void setVenueName(String venueName) {
        if (!TextUtils.isEmpty(venueName)) {
            mVenueName.setText(venueName);
        }
    }

    @Override
    public void setArtistPopularity(String artiestPopularity) {
        if (!TextUtils.isEmpty(artiestPopularity)) {
            mArtistPopularity.setText(artiestPopularity);
        }
    }

    @Override
    public void setVenueCountry(String venueCountry) {
        if (!TextUtils.isEmpty(venueCountry)) {
            mVenueCountry.setText(venueCountry);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_favorite:
                mPresenter.manageFavorite(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.findItem(R.id.action_favorite);
        mPresenter.subscribeMenu(menuItem);
        return super.onPrepareOptionsMenu(menu);
    }

    @OnTextChanged(R.id.tour_name_edit_text)
    void onTextChanged(CharSequence text) {
        mPresenter.tourNameChanged(text);
    }
}
