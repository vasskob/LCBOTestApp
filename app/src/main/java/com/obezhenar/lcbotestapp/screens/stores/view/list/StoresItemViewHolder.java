package com.obezhenar.lcbotestapp.screens.stores.view.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.obezhenar.lcbotestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoresItemViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_title)
    public TextView titleTextView;
    @BindView(R.id.tv_address)
    public TextView addressTextView;

    public StoresItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
