package com.obezhenar.lcbotestapp.screens.products.view.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.obezhenar.lcbotestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_product)
    public ImageView productImageView;
    @BindView(R.id.tv_product_name)
    public TextView productNameTextView;
    @BindView(R.id.tv_product_description)
    public TextView productDescriptionTextView;

    public ProductViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
