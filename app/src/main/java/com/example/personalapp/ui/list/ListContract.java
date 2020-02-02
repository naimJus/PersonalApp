package com.example.personalapp.ui.list;

import android.view.MenuItem;

import com.example.personalapp.data.Ticket;
import com.example.personalapp.ui.BaseView;

public interface ListContract {

    interface View extends BaseView {

        void setAdapter(TicketAdapter ticketAdapter);

        void openDetailsActivity(Ticket ticket);

        void notifyDatasetChanged(TicketAdapter ticketAdapter);
    }

    interface Presenter {

        void subscribe();

        void changeList(MenuItem item);
    }
}
