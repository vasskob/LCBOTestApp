package com.obezhenar.lcbotestapp.screens;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.screens.about.view.AboutFragment;
import com.obezhenar.lcbotestapp.screens.eventbus.ShowProductDetailsEvent;
import com.obezhenar.lcbotestapp.screens.eventbus.ShowStoreDetailsEvent;
import com.obezhenar.lcbotestapp.screens.eventbus.ShowStoreProductsEvent;
import com.obezhenar.lcbotestapp.screens.product_details.view.ProductDetailsDialog;
import com.obezhenar.lcbotestapp.screens.products.view.ProductsFragment;
import com.obezhenar.lcbotestapp.screens.products.view.ProductsPagerFragment;
import com.obezhenar.lcbotestapp.screens.search.view.SearchByProductsFragment;
import com.obezhenar.lcbotestapp.screens.store_details.view.StoreDetailsFragment;
import com.obezhenar.lcbotestapp.screens.stores.view.StoresFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.navigation)
    NavigationView navigationView;

    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;

    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        setSupportActionBar(toolbar);
        initNavigation();
        displayStoresScreen();
    }

    private void displayStoresScreen() {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, new StoresFragment())
                .commit();
    }

    private void initNavigation() {
        navigationView.setNavigationItemSelectedListener(this);
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.app_name,
                R.string.app_name
        );
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.getDrawerArrowDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        drawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_item_stores:
                displayStoresScreen();
                break;
            case R.id.menu_item_products:
                showProductsFragment(-1);
                break;
            case R.id.menu_item_search_products:
                showSearchFragment();
                break;
            case R.id.menu_item_about:
                showAboutScreen();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showSearchFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, new SearchByProductsFragment())
                .commit();
    }

    private void showAboutScreen() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, new AboutFragment())
                .commit();
    }

    @Subscribe
    public void onShowStoreDetailsEvent(ShowStoreDetailsEvent event) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, StoreDetailsFragment.newInstance(event.getStoreId()))
                .addToBackStack(null)
                .commit();
    }

    @Subscribe
    public void onShowStoreProductsEvent(ShowStoreProductsEvent event) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, ProductsPagerFragment.newInstance(event.getStoreId()))
                .addToBackStack(null)
                .commit();
    }

    @Subscribe
    public void onShowProductDetailEvent(ShowProductDetailsEvent event) {
        ProductDetailsDialog.newInstance(event.getProductId()).show(
                getSupportFragmentManager(), null
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void showProductsFragment(long storeId) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, ProductsPagerFragment.newInstance(storeId))
                .commit();
    }
}
