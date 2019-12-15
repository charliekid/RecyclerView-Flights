package com.example.imperialaircharter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.imperialaircharter.DB.AppDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class RvViewAllFlightsActivity extends AppCompatActivity {

    private static final String TAG = "RvViewAllFlightsActivit";

    private List<String> mNames = new ArrayList<>();
    private List<Flight> flightList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");
        ButterKnife.bind(this);


        addFlights();

    }
    private void addFlights(){
        Flight starDestroyer101 = new Flight("StarDestroyer101", "Tatoonie", "Naboo", "10:00(am)", 10, 150.00);
        Flight starDestroyer102 = new Flight("StarDestroyer102", "Naboo", "Tatoonie", "1:00(pm)", 10, 150.00);
        Flight starDestroyer201 = new Flight("StarDestroyer201", "Tatoonie", "Jakku", "11:00(am)", 5, 200.50);
        Flight starDestroyer205 = new Flight("StarDestroyer205", "Tatooine", "Jakku", "3:00(pm)", 15, 150.00);
        Flight starDestroyer202 = new Flight("StarDestroyer202", "Jakku", "Tatooine", "2:00(pm)", 5, 200.50);

        flightList.add(starDestroyer101);
        flightList.add(starDestroyer102);
        flightList.add(starDestroyer201);
        flightList.add(starDestroyer205);
        flightList.add(starDestroyer202);
        for(Flight flight : flightList) {
            mNames.add(flight.toString());
        }

        initRecyclerView();
    };


    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        FlightRecyclerViewAdapter adapter = new FlightRecyclerViewAdapter(this, mNames);
        recyclerView.setAdapter(adapter);
        Log.d(TAG, "after the adapter was set.");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
