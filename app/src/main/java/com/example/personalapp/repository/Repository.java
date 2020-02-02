package com.example.personalapp.repository;

public interface Repository {

    void getTickets(RepositoryImpl.CompleteCallback completeCallback);
}
