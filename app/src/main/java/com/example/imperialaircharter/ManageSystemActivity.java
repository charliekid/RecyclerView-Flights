package com.example.imperialaircharter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ManageSystemActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_system);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        // Validates the username and password
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidLogin(usernameEditText, passwordEditText)) {
                    Log.i("Login Username is: ", usernameEditText.getText().toString());
                    Log.i("Login Password is: ", passwordEditText.getText().toString());

                    Intent intent = new Intent(ManageSystemActivity.this, ViewLogActivity.class);
                    startActivity(intent);
                } else {
                    showErrorDialog();
                }
            }
        });

    }
    private boolean isValidLogin(EditText username, EditText password) {
        return isValidUsername(username) && isValidPassword(password);
    }

    private boolean isValidUsername(EditText username) {
        return username.getText().toString().equals("admin2");
    }

    private boolean isValidPassword(EditText password) {
        return password.getText().toString().equals("admin2");
    }

    private void showErrorDialog() {
        // Start building the alert
        AlertDialog.Builder builder = new AlertDialog.Builder(ManageSystemActivity.this);
        builder.setTitle("Confirm Error");
        builder.setCancelable(true);

        // Inform the user it is incorrect
        builder.setMessage(R.string.incorrectLogInDialog);


        // The user can cancel
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Show the alert
        AlertDialog alert = builder.create();
        alert.show();

    }
}
