package com.obezhenar.lcbotestapp.screens.store_details.view.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obezhenar.lcbotestapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeatureListAdapter extends RecyclerView.Adapter<FeatureListAdapter.FeatureListViewHolder> {
    private List<String> items;

    public FeatureListAdapter(@NonNull List<String> items) {
        this.items = items;
    }

    @Override
    public FeatureListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FeatureListViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_feature, parent, false));
    }

    @Override
    public void onBindViewHolder(FeatureListViewHolder holder, int position) {
        holder.featureTextView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class FeatureListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_feature)
        public TextView featureTextView;

        public FeatureListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
