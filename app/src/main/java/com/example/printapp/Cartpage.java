package com.example.printapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Cartpage extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView recyclerView;
    private int[] image={R.drawable.ic_book,R.drawable.ic_pencil,R.drawable.ic_brush_black_24dp};
    private String[] name = {"Book","Pen","Pencil"};
    private String[] des = {"ClassmateBook","Parker Pen","Apsara Pencil"};
    private String[] price = {"50","5","5"};
    public String result="";
    private RecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter.Imageviewholder imageviewholder;
    String products=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar t =findViewById(R.id.toolbar);
        Button button= findViewById(R.id.placeorder);
        Button button1=findViewById(R.id.elebutton);
        recyclerView=findViewById(R.id.recyle);
        layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RecyclerAdapter(image,name,des,price,this);
        recyclerView.setAdapter(adapter);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("LE STATIONNAIRE");
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        products=adapter.getFins();
        Intent intent = new Intent(Cartpage.this,Placeorder.class);
        intent.putExtra("prod",products);
        Log.d("TAG",products);
        startActivity(intent);
    }
}
