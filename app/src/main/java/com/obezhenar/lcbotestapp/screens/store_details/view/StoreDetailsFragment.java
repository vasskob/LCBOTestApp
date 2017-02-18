package com.obezhenar.lcbotestapp.screens.store_details.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.app.LcboApplication;
import com.obezhenar.lcbotestapp.screens.eventbus.ShowStoreProductsEvent;
import com.obezhenar.lcbotestapp.screens.store_details.model.StoreDetailsViewModel;
import com.obezhenar.lcbotestapp.screens.store_details.presenter.StoreDetailsPresenter;
import com.obezhenar.lcbotestapp.screens.store_details.view.list.FeatureListAdapter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StoreDetailsFragment extends Fragment implements StoreDetailsView {
    @BindView(R.id.rv_store_features)
    RecyclerView featuresRecyclerView;
    @BindView(R.id.tv_name)
    TextView nameTextView;
    @BindView(R.id.mapview)
    MapView mapView;
    private GoogleMap map;
    private StoreDetailsViewModel model;

    @Inject
    StoreDetailsPresenter presenter;
    private static final String KEY_STORE_ID = StoreDetailsFragment.class.getName() + ".KEY_STORE_ID";

    public static StoreDetailsFragment newInstance(long id) {
        Bundle args = new Bundle();
        args.putLong(KEY_STORE_ID, id);
        StoreDetailsFragment instance = new StoreDetailsFragment();
        instance.setArguments(args);
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LcboApplication.dependencyGraph.initStoreDetailsComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.store_details_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        presenter.attachToView(this);
        featuresRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mapView.onCreate(savedInstanceState);
        presenter.loadStore(getArguments().getLong(KEY_STORE_ID, -1));
    }

    @Override
    public void displayStoreDetails(StoreDetailsViewModel model) {
        featuresRecyclerView.setAdapter(new FeatureListAdapter(model.getFeatures()));
        nameTextView.setText(model.getTitle());
        showPlace(model.getLatitude(), model.getLongitude(), model.getAddress());
        this.model = model;
    }

    private void showPlace(double lat, double lng, String address) {
        final LatLng place = new LatLng(lat, lng);
        if (map == null)
            mapView.getMapAsync(googleMap -> {
                map = googleMap;
                setMarker(place, address);
                mapView.onResume();
            });
        else
            setMarker(place, address);
    }

    private void setMarker(LatLng marker, String address) {
        map.addMarker(new MarkerOptions().position(marker).title(address));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 16));
    }

    @OnClick(R.id.btn_call)
    public void onMakeCallClick() {
        if (model != null && !model.getPhone().isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", model.getPhone(), null));
            startActivity(intent);
        }
    }

    @OnClick(R.id.btn_show_products)
    public void onShowProductsClick() {
        if (model != null)
            EventBus.getDefault().post(new ShowStoreProductsEvent(model.getId()));
    }

    @Override
    public void displayError(Throwable throwable) {
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT);
    }

    @Override
    public void setShowProgress(boolean showProgress) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LcboApplication.dependencyGraph.releaseStoreDetailsComponent();
    }
}
