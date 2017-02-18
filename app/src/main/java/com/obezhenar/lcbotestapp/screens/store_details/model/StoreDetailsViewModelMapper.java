package com.obezhenar.lcbotestapp.screens.store_details.model;

import android.content.Context;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.common.util.Mapper;
import com.obezhenar.lcbotestapp.domain.entiry.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StoreDetailsViewModelMapper implements Mapper<Store, StoreDetailsViewModel> {
    private Context context;

    public StoreDetailsViewModelMapper(Context context) {
        this.context = context;
    }

    @Override
    public StoreDetailsViewModel map(Store data) {
        StoreDetailsViewModel model = new StoreDetailsViewModel();
        model.setId(data.getId());
        model.setLatitude(data.getLatitude());
        model.setLongitude(data.getLongitude());
        model.setPhone(data.getTelephone());
        model.setTitle(data.getName());
        model.setAddress(data.getCity() + ", " + data.getAddress1());
        model.setFeatures(obtainFeatures(data));
        return model;
    }

    private List<String> obtainFeatures(Store data) {
        List<String> features = new ArrayList<>();
        if (data.getHasBilingualServices())
            features.add(context.getString(R.string.has_bilingual_services));
        if (data.getHasBeerColdRoom())
            features.add(context.getString(R.string.has_beer_cold_room));
        if (data.getHasTastingBar())
            features.add(context.getString(R.string.has_testing_bar));
        if (data.getHasParking())
            features.add(context.getString(R.string.has_parking));
        if (data.getHasWheelchairAccessability())
            features.add(context.getString(R.string.has_wheelchair_accessability));
        if (data.getHasVintagesCorner())
            features.add(context.getString(R.string.has_vintage_corner));
        return features;
    }
}
