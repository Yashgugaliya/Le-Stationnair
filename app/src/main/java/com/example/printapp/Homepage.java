package com.example.printapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar t =findViewById(R.id.toolbar);
        Button b =findViewById(R.id.button);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("LE STATIONNAIRE");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, Cartpage.class));

            }
        });
    }
}
