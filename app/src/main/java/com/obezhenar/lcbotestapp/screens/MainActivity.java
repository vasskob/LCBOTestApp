package com.obezhenar.lcbotestapp.screens;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.design.widget.NavigationView;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.screens.eventbus.ShowStoreDetailsEvent;
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
        getSupportFragmentManager().beginTransaction()
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

        }
        return true;
    }

    @Subscribe
    public void onShowStoreDetailsEvent(ShowStoreDetailsEvent event) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, StoreDetailsFragment.newInstance(event.getStoreId()))
                .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
