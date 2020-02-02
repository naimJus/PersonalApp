package com.example.personalapp.ui.list;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalapp.R;
import com.example.personalapp.data.Ticket;
import com.example.personalapp.ui.BaseApplication;
import com.example.personalapp.ui.details.DetailsActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity implements ListContract.View {

    @BindView(R.id.ticket_recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    ListContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        initDagger();

        mPresenter.subscribe();
    }

    private void initDagger() {
        DaggerListComponent.builder()
                .appComponent(BaseApplication.getComponent())
                .listViewModule(new ListViewModule(this))
                .listPresenterModule(new ListPresenterModule())
                .build()
                .inject(this);
    }

    @Override
    public void setAdapter(TicketAdapter ticketAdapter) {
        mRecyclerView.setAdapter(ticketAdapter);
    }

    @Override
    public void openDetailsActivity(Ticket ticket) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.TICKET_EXTRA, ticket);
        startActivity(intent);
    }
}
