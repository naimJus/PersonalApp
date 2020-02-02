package com.example.personalapp.ui.details;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.personalapp.R;

public class DetailsActivity extends AppCompatActivity {

    public static final String TICKET_EXTRA = DetailsActivity.class.getSimpleName() + "ticket_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }
}
