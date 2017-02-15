package com.obezhenar.lcbotestapp.screens.base;

import android.view.View;

public interface OnItemClickListener<T> {
    void onItemClick(View itemView, T item);
}
