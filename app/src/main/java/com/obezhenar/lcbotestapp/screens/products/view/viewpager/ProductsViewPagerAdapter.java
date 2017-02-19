package com.obezhenar.lcbotestapp.screens.products.view.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.obezhenar.lcbotestapp.screens.products.view.ProductsFragment;

public class ProductsViewPagerAdapter extends FragmentStatePagerAdapter {
    private long storeId;
    private String[] categories;

    public ProductsViewPagerAdapter(
            long storeId,
            String[] categories,
            FragmentManager fm) {
        super(fm);
        this.storeId = storeId;
        this.categories = categories;
    }

    @Override
    public Fragment getItem(int position) {
        return ProductsFragment.newInstance(storeId, categories[position]);
    }

    @Override
    public int getCount() {
        return categories.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return categories[position];
    }


}
