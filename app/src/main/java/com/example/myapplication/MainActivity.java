package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.ui.info.InfoScreen;
import com.example.myapplication.ui.products.ProductListScreen;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        Button infoBtn = (Button) findViewById(R.id.infoBtn);
        Button goodsListBtn = (Button) findViewById(R.id.goodsListBtn);

        Intent infoView = new Intent(this, InfoScreen.class);
        Intent productListView = new Intent(this, ProductListScreen.class);

        infoBtn.setOnClickListener(v -> startActivity(infoView));
        goodsListBtn.setOnClickListener(v -> startActivity(productListView));
    }
}