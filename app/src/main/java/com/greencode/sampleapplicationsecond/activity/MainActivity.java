package com.greencode.sampleapplicationsecond.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.greencode.sampleapplicationsecond.R;
import com.greencode.sampleapplicationsecond.fragments.DiscoverFragment;
import com.greencode.sampleapplicationsecond.fragments.MyTradeMeFragment;
import com.greencode.sampleapplicationsecond.fragments.WatchlistFragment;
import com.greencode.sampleapplicationsecond.model.Products;
import com.greencode.sampleapplicationsecond.response.ServiceResponse;
import com.greencode.sampleapplicationsecond.retrofitAPI.ApiClient;
import com.greencode.sampleapplicationsecond.retrofitAPI.ApiInterface;
import com.greencode.sampleapplicationsecond.utils.MyDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    DiscoverFragment firstFragment = new DiscoverFragment();
    WatchlistFragment secondFragment = new WatchlistFragment();
    MyTradeMeFragment thirdFragment = new MyTradeMeFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBar();
    }

    public void setActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFFFF")));
            getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        }
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_discover);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_discover:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, firstFragment).commit();
                return true;

            case R.id.menu_watchlist:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, secondFragment).commit();
                return true;

            case R.id.menu_mytrademe:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, thirdFragment).commit();
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                Toast.makeText(this, getResources().getString(R.string.search_menu_clicked), Toast.LENGTH_SHORT).show();
                return (true);
            case R.id.menu_cart:
                Toast.makeText(this, getResources().getString(R.string.cart_menu_clicked), Toast.LENGTH_SHORT).show();
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }


}