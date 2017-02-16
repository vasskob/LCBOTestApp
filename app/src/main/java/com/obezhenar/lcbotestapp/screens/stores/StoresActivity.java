package com.obezhenar.lcbotestapp.screens.stores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.obezhenar.lcbotestapp.R;
import com.obezhenar.lcbotestapp.app.LcboApplication;
import com.obezhenar.lcbotestapp.screens.stores.view.StoresFragment;

public class StoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, new StoresFragment())
                .commit();
    }
}
