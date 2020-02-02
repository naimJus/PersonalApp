package com.example.personalapp.ui.list;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.personalapp.R;
import com.example.personalapp.data.Ticket;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Ticket ticket = mDataSet.get(position);
        holder.mEventImageDrawee.setImageURI(Uri.parse(ticket.getArtistImage()));
        holder.mTourNameTextView.setText(ticket.getArtistTourName());
        holder.mEventNameTextView.setText(ticket.getArtistName());
        holder.mEventDateTextView.setText(ticket.getEventDate());
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
        @BindView(R.id.event_image_view)
        SimpleDraweeView mEventImageDrawee;
        @BindView(R.id.tour_name_text_view)
        TextView mTourNameTextView;
        @BindView(R.id.event_name_text_view)
        TextView mEventNameTextView;
        @BindView(R.id.event_date_text_view)
        TextView mEventDateTextView;

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
