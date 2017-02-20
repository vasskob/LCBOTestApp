package com.obezhenar.lcbotestapp.screens.product_details.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.app.LcboApplication;
import com.obezhenar.lcbotestapp.screens.product_details.model.ProductDetailsViewModel;
import com.obezhenar.lcbotestapp.screens.product_details.presenter.ProductDetailsPresenter;
import com.obezhenar.lcbotestapp.screens.products.model.ProductViewModel;

import org.w3c.dom.Text;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductDetailsDialog extends DialogFragment implements ProductDetailsView {
    private static final String KEY_PRODUCT_ID = ProductDetailsDialog.class.getName() + ".KEY_PRODUCT_ID";
    @Inject
    ProductDetailsPresenter presenter;
    @BindView(R.id.iv_product)
    ImageView imageView;
    @BindView(R.id.tv_title)
    TextView titleTextView;
    @BindView(R.id.tv_price)
    TextView priceTextView;
    @BindView(R.id.tv_alcohol_content)
    TextView alcoholContentTextView;
    @BindView(R.id.tv_description)
    TextView descriptionTextView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.v_details)
    View detailsView;
    private long productId;

    public static ProductDetailsDialog newInstance(long productId) {
        Bundle args = new Bundle();
        args.putLong(KEY_PRODUCT_ID, productId);
        ProductDetailsDialog instance = new ProductDetailsDialog();
        instance.setArguments(args);
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productId = getArguments().getLong(KEY_PRODUCT_ID, -1);
        LcboApplication.dependencyGraph.initProductDetailsComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        presenter.attach(this);
        presenter.loadProductDetails(productId);
    }

    @Override
    public void displayProductDetails(ProductDetailsViewModel details) {
        Glide.with(getContext())
                .load(details.getImagePath())
                .into(imageView);
        titleTextView.setText(details.getName());
        priceTextView.setText('$' + details.getPrice());
        alcoholContentTextView.setText(details.getAlcoholContent() + '%');
        descriptionTextView.setText(details.getDescription());
    }

    @Override
    public void displayError(String message) {
        titleTextView.setText(message);
    }

    @Override
    public void setShowProgress(boolean showProgress) {
        if (showProgress) {
            detailsView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            detailsView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.btn_ok)
    public void onOkClick() {
        dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LcboApplication.dependencyGraph.releaseProductDetailsComponent();
    }
}
