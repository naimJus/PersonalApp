package com.example.personalapp.repository;

import com.example.personalapp.data.Ticket;

public interface Repository {

    void getTickets(RepositoryImpl.CompleteCallback completeCallback);

    void setFavorite(boolean isFavorite, int eventId);

    void setFavorite(boolean isFavorite, Ticket ticket);
}
