package com.example.myapplication.ui.products.popUps;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.myapplication.R;
import com.example.myapplication.ui.products.ProductListScreen;

import static com.example.myapplication.R.id.categoryValue;

public class CategoryPopUp {

    public void showPopupWindow(final View view, String value, ProductListScreen screen, boolean isEdit) {
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(view.getContext().LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.add_category_pop_up, null);

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;

        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        ((EditText) popupView.findViewById(categoryValue)).setText(value);

        Button cancelBtn = (Button) popupView.findViewById(R.id.cancelBtn);
        Button submitBtn = (Button) popupView.findViewById(R.id.submitBtn);

        cancelBtn.setOnClickListener(v -> popupWindow.dismiss());
        submitBtn.setOnClickListener(v -> {
            if (isEdit) {
                screen.editCategory(value, ((EditText) popupView.findViewById(categoryValue)).getText().toString());
            } else {
                screen.addCategory(((EditText) popupView.findViewById(categoryValue)).getText().toString());
            }
            popupWindow.dismiss();
        });
    }
}
