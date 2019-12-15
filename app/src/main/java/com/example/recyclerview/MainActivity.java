package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private List<String> mNames = new ArrayList<>();
    private List<Flight> flightList = new ArrayList<>();
    //private List<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

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
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

////        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
//        mNames.add("Havasu Falls");
//
////        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
//        mNames.add("Trondheim");
//
////        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
//        mNames.add("Portugal");
//
////        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
//        mNames.add("Rocky Mountain National Park");
//
//
////        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
//        mNames.add("Mahahual");
//
////        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
//        mNames.add("Frozen Lake");
//
//
////        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
//        mNames.add("White Sands Desert");
//
////        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
//        mNames.add("Austrailia");
//
////        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
//        mNames.add("Washington");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
