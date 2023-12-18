package com.zanita.posapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {
    ImageButton imageButton, daySalesButton, purchaseButton, orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        imageButton = (ImageButton) findViewById(R.id.imageButton);
        daySalesButton = findViewById(R.id.imageButton3);
        purchaseButton = findViewById(R.id.imageButton4);
        orderButton = findViewById(R.id.imageButton5);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                startActivity(new Intent(HomePage.this, Transaction.class));
            }

        });

        daySalesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, Day_sales.class));
            }
        });

        purchaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, Purchases.class));
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, Checkout.class));
            }
        });
    }


}