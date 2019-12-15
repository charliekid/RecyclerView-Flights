package com.example.imperialaircharter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imperialaircharter.DB.AppDatabase;

public class MainActivity extends AppCompatActivity {

    Button createAccountButton;
    Button reserveSeatButton;
    Button cancelReservationButton;
    Button manageSystemButton;
    // Delete this button afterwards
    Button viewFlightsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create the database
        AppDatabase.getInstance(MainActivity.this).loadData(this);

        createAccountButton = findViewById(R.id.createAccountButton);
        reserveSeatButton = findViewById(R.id.reserveSeatButton);
        cancelReservationButton = findViewById(R.id.cancelReservationButton);
        manageSystemButton = findViewById(R.id.manageSystemButton);
        viewFlightsButton = findViewById(R.id.viewFlightButton);



        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });

        reserveSeatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cancelReservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        manageSystemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManageSystemActivity.class);
                startActivity(intent);
            }
        });

        viewFlightsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, ViewAllFlightsActivity.class);
                Intent intent = new Intent(MainActivity.this, RvViewAllFlightsActivity.class);
                startActivity(intent);
            }
        });


    }
}
