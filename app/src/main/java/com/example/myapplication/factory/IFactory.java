package com.example.myapplication.factory;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public interface IFactory<T> {
    Button createButton(Context ctx, String buttonText, View.OnClickListener listener);
    TextView createText(Context ctx, String text, int id);
}
