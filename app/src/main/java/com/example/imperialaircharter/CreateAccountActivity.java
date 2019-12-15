package com.example.imperialaircharter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import com.example.imperialaircharter.DB.AppDatabase;
import com.example.imperialaircharter.DB.ImperialAirCharterDAO;

import java.util.Calendar;
import java.util.List;

public class CreateAccountActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    Button createAccountButton;

    TextView databaseTextView;
    ImperialAirCharterDAO imperialAirCharterDAO;
    List<User> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        createAccountButton = findViewById(R.id.createAccountButton);

        databaseTextView = findViewById(R.id.databaseTextView);
        imperialAirCharterDAO = AppDatabase.getInstance(CreateAccountActivity.this).dao();


        // Database set up
//        imperialAirCharterDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.USERS_DB_NAME)
//                .allowMainThreadQueries()
//                .build()
//                 .dao();
//                //.getUserDAO();

//        refreshDisplay();

        // Check to make sure the inputs are valid inputs
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usernameEditText.getText().toString().equals("admin2") || passwordEditText.getText().toString().equals("admin2")) {
                    showUsernameErrorDialog();
                } else if(isValidAccountCreation(usernameEditText, passwordEditText)) {
                    // TODO : add to log that an account was created was created

                    // checking to see if the user exists in the database
                    User user = AppDatabase.getInstance(CreateAccountActivity.this).dao().getUsername(usernameEditText.getText().toString());
                    if(user == null) {
                        User newUser = new User(usernameEditText.getText().toString(), passwordEditText.getText().toString());
                        imperialAirCharterDAO.addUser(newUser);
                        //add to the log
                        addLog(imperialAirCharterDAO, "New Account", usernameEditText.getText().toString(), "New account created");
                        showSuccessDialog();
                    } else {
                        showUsernameErrorDialog();
                    }
                } else {
                    showErrorDialog();
                }
            }
        });
        //databaseTextView = findViewById(R.id.databaseTextView);
    }

    /**
     * Wrapper method that checks if the username and password EditText has at least 3 alpha
     * and one number
     * @param username - The users input for a username
     * @param password - The users input for a password corresponding with the user name
     * @return true - if it is a valid account creation
     */
    private boolean isValidAccountCreation(EditText username, EditText password) {
        return isValidUsername(username) && isValidPassword(password);
    }

    /**
     * Checks to see if the username is a correct format
     * @param username - the users input for a username
     * @return true - if the username has 3 alpha and one number
     */
    private boolean isValidUsername(EditText username) {
        String userInput = username.getText().toString();

        return hasAlpha(userInput) && hasNumbers(userInput);
    }

    /**
     * Checks to see if the password is correct format
     * @param password - the users input for a password
     * @return true - if the password has 3 alpha and one number
     */
    private boolean isValidPassword(EditText password) {
        String userInput = password.getText().toString();

        return hasAlpha(userInput) && hasNumbers(userInput);
    }

    /**
     * Checks to see if a string has at least 3 alpha characters in it
     * @param inputString - the target string that will be checked
     * @return - true if the string has 3 alpha characters
     */
    private boolean hasAlpha(String inputString) {
        int count = 0;
        boolean result = false;
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isAlphabetic(inputString.charAt(i))) {
                count++;
            }
        }
        if(count >= 3) {
            result = true;
        }
        //Log.i("TAGCAA", "# of Alpha " + count + " in " + inputString);
        return result;

    }

    /**
     * Checks to see if a String has at least 1 number in it
     * @param inputString - the target String that will be checked
     * @return true - if the String has 1 number
     */
    private boolean hasNumbers(String inputString) {
        int count = 0;
        boolean result = false;
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                count++;
            }
        }
        if(count >= 1) {
            result = true;
        }

        //Log.i("TAGCAA", "# of numbers " + count + " in " + inputString);
        return result;

    }

    /**
     * This method uses AlertDialog builder to display an error to the user that their input
     * does not have 3 alpha and one number
     */
    private void showErrorDialog() {
        // Start building the alert
        AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccountActivity.this);
        builder.setTitle("Confirm Error");
        builder.setCancelable(true);

        // Inform the user it is incorrect
        builder.setMessage(R.string.incorrectAccountCreationDialog);


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

    /**
     * Displays the user that their account was successfully created.
     */
    private void showSuccessDialog() {
        // Start building the alert
        AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccountActivity.this);
        builder.setTitle("Account Successfully Created");
        builder.setCancelable(true);

        // Inform the user it is incorrect
        builder.setMessage(R.string.accountCreatedMessage);


        // The user can cancel
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(CreateAccountActivity.this, MainActivity.class);
                startActivity(intent);
                dialog.cancel();
            }
        });

        // Show the alert
        AlertDialog alert = builder.create();
        alert.show();

    }

    /**
     * Displays to the user that the username they are trying to use is taken.
     */
    private void showUsernameErrorDialog() {
        // Start building the alert
        AlertDialog.Builder builder = new AlertDialog.Builder(CreateAccountActivity.this);
        builder.setTitle("Confirm Error");
        builder.setCancelable(true);

        // Inform the user it is incorrect
        builder.setMessage("User name is taken");


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

    /**
     * This will add to the log database
     * @param dao - the database instance we are adding to
     * @param transactionType - the type of transaction the log will be seen as
     * @param username - the username that is associated with the log
     * @param detailedMessage - a message describing the reason for the log
     */
    public void addLog(ImperialAirCharterDAO dao, String transactionType, String username, String detailedMessage) {
        //long time = System.currentTimeMillis();
        String timeString = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        long time = Long.parseLong(timeString.replaceAll("_", ""));
        LogRecord aLog = new LogRecord(time, transactionType, username, detailedMessage);
        dao.addLogRecord(aLog);
    }

    // check if user name is does not exists

    // add into the database

    // add to log that an account was created
    private void addToDatabase() {
        String usernameString = usernameEditText.getText().toString();
        String passwordString = passwordEditText.getText().toString();

        User user = new User(usernameString, passwordString);
        imperialAirCharterDAO.insert(user);
    }

    private void refreshDisplay() {
        usersList = imperialAirCharterDAO.getAllUsers();
        if(! usersList.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for(User user: usersList) {
                stringBuilder.append(user.toString());
            }
            databaseTextView.setText(stringBuilder.toString());
        } else {
            databaseTextView.setText("we need some users");
        }

    }

}
