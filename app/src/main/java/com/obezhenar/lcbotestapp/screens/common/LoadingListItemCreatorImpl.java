package com.obezhenar.lcbotestapp.screens.common;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obezhenar.lcbotestapp.R;
import com.paginate.recycler.LoadingListItemCreator;

public class LoadingListItemCreatorImpl implements LoadingListItemCreator {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StoreLoadingItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_loading, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    class StoreLoadingItemViewHolder extends RecyclerView.ViewHolder {

        public StoreLoadingItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}