package com.example.personalapp.ui.list;

import com.example.personalapp.data.Ticket;

public interface ListContract {

    interface View {

        void setAdapter(TicketAdapter ticketAdapter);

        void openDetailsActivity(Ticket ticket);

    }

    interface Presenter {

        void subscribe();
    }
}
