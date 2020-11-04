package com.example.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class campusselect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campusselect);
    }

    public void openkengeri(View view) {
        Intent send = new Intent(campusselect.this, shop_list_keng.class);
        startActivity(send);
    }
}