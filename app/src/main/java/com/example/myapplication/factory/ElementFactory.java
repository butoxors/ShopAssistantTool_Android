package com.example.myapplication.factory;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.ui.products.ProductListScreen;

public class ElementFactory<T extends ProductListScreen> implements IFactory<T> {
    @Override
    public Button createButton(Context ctx, String buttonText, View.OnClickListener listener) {
        Button button = new Button(ctx);
        button.setText(buttonText);
        button.setWidth(200);
        button.setHeight(30);
        button.setOnClickListener(listener);

        return button;
    }

    @Override
    public TextView createText(Context ctx, String text, int id) {
        TextView name = new TextView(ctx);
        name.setId(id);
        name.setText(text);
        name.setTextSize(16);
        name.setWidth(300);
        name.setHeight(100);
        name.setGravity(Gravity.FILL);

        return name;
    }
}
