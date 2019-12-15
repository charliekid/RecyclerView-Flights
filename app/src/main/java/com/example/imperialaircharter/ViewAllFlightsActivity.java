package com.example.imperialaircharter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.imperialaircharter.DB.AppDatabase;

import java.util.List;

public class ViewAllFlightsActivity extends AppCompatActivity {

    List<Flight> flightsList;
    TextView databaseTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_flights);

        // you left off on slide 39.
       // flightsList = AppDatabase.getInstance(this).dao().getAllFlights();
        databaseTextView = findViewById(R.id.flightInfoTextView);

        refreshDisplay();

    }

    /**
     * Reloads the display with all the flights
     */
    private void refreshDisplay() {
        flightsList = AppDatabase.getInstance(this).dao().getAllFlights();
        if(! flightsList.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for(Flight flight: flightsList) {
                stringBuilder.append(flight.toString());
            }
            databaseTextView.setText(stringBuilder.toString());
        } else {
            databaseTextView.setText("we need some flights");
        }
    }
}
