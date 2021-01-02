package com.example.myapplication.ui.products;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.factory.ElementFactory;
import com.example.myapplication.ui.products.category.CategoryScreen;
import com.example.myapplication.ui.products.popUps.CategoryPopUp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductListScreen extends AppCompatActivity {
    private static final ElementFactory factory = new ElementFactory();
    private static List<String> categories = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);

        categories.addAll(Arrays.asList("Сигареты", "Алкоголь", "Продукты", "Выпечка", "Напитки"));

        addCategories(categories);

        Button addCategoryBtn = findViewById(R.id.addCategoryBtn);
        addCategoryBtn.setOnClickListener(v -> {
            CategoryPopUp popUp = new CategoryPopUp();
            popUp.showPopupWindow(v, "", this, false);
        });
    }

    public void addCategory(String category) {
        categories.add(category);
        addCategories(Arrays.asList(category));
    }

    public void editCategory(String oldCategory, String newCategory) {
        int index = categories.indexOf(oldCategory);

        if (index == -1) {
            throw new NullPointerException();
        } else {
            categories.set(index, newCategory);
            TextView text = findViewById(index);
            text.setText(newCategory);
        }
    }

    private void addCategories(List<String> categories) {
        TableLayout table = findViewById(R.id.categoryLayout);

        for (int i = 0; i < categories.size(); i++) {
            String cat = categories.get(i);

            TableRow row = new TableRow(table.getContext());
            row.addView(factory.createText(row.getContext(), cat, i));

            initButtons(row, cat);

            table.addView(row);
        }
    }

    private void initButtons(LinearLayout layout, String category) {
        Context ctx = layout.getContext();

        layout.addView(factory.createButton(ctx, "Add", v -> {
            Intent intent = new Intent(this, CategoryScreen.class);
            startActivity(intent);
        }));
        layout.addView(factory.createButton(ctx, "Edit", v -> {
            CategoryPopUp popUp = new CategoryPopUp();
            popUp.showPopupWindow(v, category, this, true);
        }));
        layout.addView(factory.createButton(ctx, "Remove", v -> {
            removeCategory(category);
        }));
    }

    private void removeCategory(String category) {
        LinearLayout layout = findViewById(R.id.categoryLayout);
        layout.removeViewAt(categories.indexOf(category));
        categories.remove(category);
    }
}
