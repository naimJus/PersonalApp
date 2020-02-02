package com.example.personalapp.repository;

import com.example.personalapp.data.Ticket;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import io.realm.Realm;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class RepositoryImpl implements Repository {
    public interface CompleteCallback {
        void onSuccess(List<Ticket> list);

        void onError(Throwable throwable);
    }

    private Realm mRealm;
    private final OkHttpClient mHttpClient;

    public RepositoryImpl(OkHttpClient okHttpClient) {
        mRealm = Realm.getDefaultInstance();
        mHttpClient = okHttpClient;
    }

    @Override
    public void getTickets(CompleteCallback completeCallback) {
        if (mRealm.where(Ticket.class).count() == 0) {
            getTicketsFromWeb(completeCallback);
        } else {
            getTicketsFromDb(completeCallback);
        }
    }


    private void getTicketsFromDb(CompleteCallback completeCallback) {
        mRealm.where(Ticket.class).findAllAsync().addChangeListener(tickets -> {
            if (completeCallback != null) {
                completeCallback.onSuccess(tickets);
            }
        });
    }

    @Override
    public void setFavorite(boolean isFavorite, int eventId) {
        //TODO Implement
    }

    @Override
    public void setFavorite(boolean isFavorite, Ticket ticket) {
        mRealm = Realm.getDefaultInstance();
        mRealm.beginTransaction();
        ticket.setFavorite(isFavorite);
        mRealm.copyToRealmOrUpdate(ticket);
        mRealm.commitTransaction();
        mRealm.close();
    }

    @Override
    public void setTourName(String tourName, Ticket ticket) {
        mRealm = Realm.getDefaultInstance();
        mRealm.beginTransaction();
        ticket.setArtistTourName(tourName);
        mRealm.copyToRealmOrUpdate(ticket);
        mRealm.commitTransaction();
        mRealm.close();
    }

    private void getTicketsFromWeb(CompleteCallback completeCallback) {
        Request request = new Request.Builder()
                .url("https://www.rang1tickets.nl/ost/apptest/")
                .build();
        mHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NotNull okhttp3.Call call, @NotNull IOException e) {
                if (completeCallback != null) {
                    completeCallback.onError(e);
                }
            }

            @Override
            public void onResponse(@NotNull okhttp3.Call call, @NotNull okhttp3.Response response) throws IOException {
                ResponseBody body = response.body();
                if (response.isSuccessful() && body != null) {
                    List<Ticket> list = new Gson().fromJson(body.string(), new TypeToken<List<Ticket>>() {
                    }.getType());
                    mRealm = Realm.getDefaultInstance();
                    mRealm.beginTransaction();
                    mRealm.copyToRealm(list);
                    mRealm.commitTransaction();
                    if (completeCallback != null) {
                        completeCallback.onSuccess(list);
                    }
                } else {
                    if (completeCallback != null) {
                        completeCallback.onError(new Exception("Failed"));
                    }
                }
            }
        });
    }
}
