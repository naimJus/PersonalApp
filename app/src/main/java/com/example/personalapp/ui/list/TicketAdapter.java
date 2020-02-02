package com.example.personalapp.ui.list;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalapp.data.Ticket;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.CustomViewHolder> {
    interface ItemSelected {
        void onItemSelected(Ticket ticket);
    }

    private List<Ticket> mDataSet;
    private ItemSelected mItemSelectedCallback;

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (mDataSet == null) {
            return 0;
        }
        return mDataSet.size();
    }

    void setDataSet(List<Ticket> list) {
        mDataSet = list;
    }

    public void setItemSelectedCallback(ItemSelected itemSelectedCallback) {
        mItemSelectedCallback = itemSelectedCallback;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick
        void onItemClicked() {
            if (mItemSelectedCallback != null) {
                mItemSelectedCallback.onItemSelected(mDataSet.get(getAdapterPosition()));
            }
        }
    }
}
