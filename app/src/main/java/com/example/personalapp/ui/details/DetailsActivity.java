package com.example.personalapp.ui.details;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.personalapp.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    public static final String TICKET_EXTRA = DetailsActivity.class.getSimpleName() + "ticket_extra";

    @BindView(R.id.poster_drawee)
    SimpleDraweeView mPosterDraweeView;
    @BindView(R.id.tour_name_text_view)
    TextView mTourNameTextView;
    @BindView(R.id.artist_name_text)
    TextView mArtistNameTextView;
    @BindView(R.id.event_date_text_view)
    TextView mEventDateTextView;
    @BindView(R.id.event_time_text_view)
    TextView mEventTimeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
    }
}
