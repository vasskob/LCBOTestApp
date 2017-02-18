package com.obezhenar.lcbotestapp.screens.products.view.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.domain.entiry.Product;
import com.obezhenar.lcbotestapp.screens.common.OnItemClickListener;
import com.obezhenar.lcbotestapp.screens.products.model.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProductsListAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private List<ProductViewModel> items = new ArrayList<>();
    private OnItemClickListener<ProductViewModel> onItemClickListener;

    public ProductsListAdapter(@NonNull OnItemClickListener<ProductViewModel> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void setItems(List<ProductViewModel> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void addToEnd(List<ProductViewModel> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_product, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        ProductViewModel product = items.get(position);
        Glide.with(holder.itemView.getContext())
                .load(product.getImagePath())
                .into(holder.productImageView);
        holder.productNameTextView.setText(product.getName());
        holder.productDescriptionTextView.setText(product.getDescription());
        holder.itemView.setOnClickListener(view -> onItemClickListener.onItemClick(view, product));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
