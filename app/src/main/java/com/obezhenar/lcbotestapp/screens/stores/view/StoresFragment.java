package com.obezhenar.lcbotestapp.screens.stores.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.app.LcboApplication;
import com.obezhenar.lcbotestapp.screens.stores.model.StoreModel;
import com.obezhenar.lcbotestapp.screens.stores.presenter.StoresPresenter;
import com.obezhenar.lcbotestapp.screens.stores.view.list.StoresListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoresFragment extends Fragment implements StoresView {
    @BindView(R.id.rv_stores)
    RecyclerView storesRecyclerView;
    @Inject
    StoresPresenter presenter;

    private StoresListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LcboApplication.dependencyGraph.initStoresComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.stores_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new StoresListAdapter((itemView, item) -> presenter.onStoreClick(item));
        storesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        storesRecyclerView.setAdapter(adapter);
        presenter.attach(this);
        presenter.onLoadMore();
    }

    @Override
    public void displayStores(List<StoreModel> stores) {
        if (stores != null)
            adapter.setData(stores);
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showStoreDetails(StoreModel storeModel) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LcboApplication.dependencyGraph.releaseStoresComponent();
        presenter.release();
    }
}
