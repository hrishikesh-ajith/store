package com.example.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class shop_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
    }

    public void openstationery(View view) {
        Intent send = new Intent(shop_list.this, stationery_list.class);
        startActivity(send);

    }

    public void opensnack(View view) {
        Intent send = new Intent(shop_list.this, snack_list.class);
        startActivity(send);
    }
}