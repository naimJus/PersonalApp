package com.example.personalapp.ui.list;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.personalapp.R;

public class ListActivity extends AppCompatActivity implements ListContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
}
