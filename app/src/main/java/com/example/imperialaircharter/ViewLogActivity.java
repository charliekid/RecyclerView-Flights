package com.example.imperialaircharter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.imperialaircharter.DB.AppDatabase;

import java.util.List;

public class ViewLogActivity extends AppCompatActivity {

    TextView logDisplay;
    Button returnButton;
    List<LogRecord> logRecordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_log);

        logDisplay = findViewById(R.id.logTextView);
        returnButton = findViewById(R.id.returnToMainMenuButton);

        //load the display with the logs
        refreshDisplay();

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewLogActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    /**
     * Reloads the display with all the flights
     */
    private void refreshDisplay() {
        logRecordList = AppDatabase.getInstance(this).dao().getAllLogRecords();
        if(! logRecordList.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for(LogRecord logRecord: logRecordList) {
                stringBuilder.append(logRecord.toString());
            }
            logDisplay.setText(stringBuilder.toString());
        } else {
            logDisplay.setText("we have no logs!");
        }
    }
}
