package com.obezhenar.lcbotestapp.screens.stores.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.screens.stores.model.StoresFilter;

public class StoresFilterDialog extends AlertDialog {

    public StoresFilterDialog(Context context) {
        super(context);
    }

    public StoresFilterDialog(Context context, int theme) {
        super(context, theme);
    }

    protected StoresFilterDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_filter, null, false);
        setView(dialogView);
    }

    public StoresFilter getStoresFilter() {
        return new StoresFilter();
    }
}
