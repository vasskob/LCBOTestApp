package com.obezhenar.lcbotestapp.screens.products.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.app.LcboApplication;
import com.obezhenar.lcbotestapp.domain.entiry.ProductType;
import com.obezhenar.lcbotestapp.screens.products.view.viewpager.ProductsViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductsPagerFragment extends Fragment {
    private static final String KEY_STORE_ID = ProductsFragment.class.getName() + ".KEY_STORE_ID";
    private long storeId;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    public static ProductsPagerFragment newInstance(long storeId) {
        Bundle args = new Bundle();
        args.putLong(KEY_STORE_ID, storeId);
        ProductsPagerFragment instance = new ProductsPagerFragment();
        instance.setArguments(args);
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storeId = getArguments().getLong(KEY_STORE_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_products_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new ProductsViewPagerAdapter(storeId, new String[]{
                ProductType.BEER.toString(),
                ProductType.WINE.toString(),
                ProductType.SPIRIT.toString()
        }, getFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
}
