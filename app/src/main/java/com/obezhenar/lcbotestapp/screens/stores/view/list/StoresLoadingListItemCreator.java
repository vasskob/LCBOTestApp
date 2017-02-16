package com.obezhenar.lcbotestapp.screens.stores.view.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obezhenar.lcbotestapp.R;
import com.paginate.recycler.LoadingListItemCreator;

public class StoresLoadingListItemCreator implements LoadingListItemCreator {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StoreLoadingItemViewLolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_loading, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    class StoreLoadingItemViewLolder extends RecyclerView.ViewHolder {

        public StoreLoadingItemViewLolder(View itemView) {
            super(itemView);
        }
    }
}