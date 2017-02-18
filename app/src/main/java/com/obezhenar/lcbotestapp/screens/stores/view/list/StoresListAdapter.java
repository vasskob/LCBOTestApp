package com.obezhenar.lcbotestapp.screens.stores.view.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.screens.common.OnItemClickListener;
import com.obezhenar.lcbotestapp.screens.stores.model.StoreModel;

import java.util.ArrayList;
import java.util.List;

public class StoresListAdapter extends RecyclerView.Adapter<StoresItemViewHolder> {
    private List<StoreModel> data = new ArrayList<>();
    private OnItemClickListener<StoreModel> onItemClickListener;

    public StoresListAdapter(OnItemClickListener<StoreModel> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(@NonNull List<StoreModel> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void clearData() {
        data.clear();
        notifyDataSetChanged();
    }

    @Override
    public StoresItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StoresItemViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.stores_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(StoresItemViewHolder holder, int position) {
        if (position < getItemCount()) {
            final StoreModel store = data.get(position);
            holder.titleTextView.setText(store.getName());
            holder.addressTextView.setText(store.getAddress());
            holder.itemView.setOnClickListener(view -> onItemClickListener.onItemClick(view, store));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
