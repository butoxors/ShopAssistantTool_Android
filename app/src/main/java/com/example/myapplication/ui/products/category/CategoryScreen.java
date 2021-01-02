package com.example.myapplication.ui.products.category;

import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryScreen extends AppCompatActivity {
    Map<String, List<String>> coll = new HashMap<>();
    List<String> titles = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_screen);

        String category = getIntent().getStringExtra("CATEGORY");
        TableLayout layout = findViewById(R.id.categoryTable);

        addTitles(layout);
        prepareData();
        
        showData(layout);
    }

    private void prepareData() {
        for (int j = 0; j < 10; j++) {
            List<String> values = new ArrayList<>();
            for (int i = 0; i < titles.size(); i++) {
                values.add(String.valueOf(i));
            }
            coll.put(String.valueOf(j), values);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showData(TableLayout layout) {
        for (int i = 0; i < coll.size(); i++) {
            TableRow row = new TableRow(layout.getContext());
            coll.get(String.valueOf(i)).forEach(x -> {
                TextView text = new TextView(row.getContext());
                text.setText(x);
                row.addView(text);
            });
            layout.addView(row);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void addTitles(TableLayout layout) {
        titles.addAll(Arrays.asList("Наименование", "Цена закупки", "Цена продажи", "Поставщик"));
        TableRow row = new TableRow(layout.getContext());

        titles.forEach(x -> {
            TextView text = new TextView(layout.getContext());
            text.setText(x);
            text.setWidth(x.length() * 25);

            row.addView(text);
        });
        layout.addView(row);
    }
}
