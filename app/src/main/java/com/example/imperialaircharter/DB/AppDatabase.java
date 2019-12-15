package com.example.imperialaircharter.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.imperialaircharter.Flight;
import com.example.imperialaircharter.LogRecord;
import com.example.imperialaircharter.User;

import java.util.List;

@Database(entities = {User.class, LogRecord.class, Flight.class}, version =1)
public abstract class AppDatabase extends RoomDatabase {

    // Singleton
    private static AppDatabase instance;

    public abstract ImperialAirCharterDAO dao();

    public static synchronized AppDatabase getInstance(Context context) {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    FLIGHTS_DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public void loadData(Context context) {
        List<User> userList = AppDatabase.getInstance(context).dao().getAllUsers();
        if(userList.size() == 0) {
            loadUsers(context);
            loadFlights(context);
        }
    }

    private void loadUsers(Context context) {
        ImperialAirCharterDAO dao = getInstance(context).dao();
        User alice = new User("alice5", "csumb100");
        User brain = new User("brain77", "123ABC");
        User chris = new User("chris21", "CHRIS21");

        dao.addUser(alice);
        dao.addUser(brain);
        dao.addUser(chris);
    }

    private void loadFlights(Context context) {
        ImperialAirCharterDAO dao = getInstance(context).dao();

        Flight starDestroyer101 = new Flight("StarDestroyer101", "Tatoonie", "Naboo", "10:00(am)", 10, 150.00);
        Flight starDestroyer102 = new Flight("StarDestroyer102", "Naboo", "Tatoonie", "1:00(pm)", 10, 150.00);
        Flight starDestroyer201 = new Flight("StarDestroyer201", "Tatoonie", "Jakku", "11:00(am)", 5, 200.50);
        Flight starDestroyer205 = new Flight("StarDestroyer205", "Tatooine", "Jakku", "3:00(pm)", 15, 150.00);
        Flight starDestroyer202 = new Flight("StarDestroyer202", "Jakku", "Tatooine", "2:00(pm)", 5, 200.50);

        dao.addFlight(starDestroyer101);
        dao.addFlight(starDestroyer102);
        dao.addFlight(starDestroyer201);
        dao.addFlight(starDestroyer205);
        dao.addFlight(starDestroyer202);

    }
    public static final String USERS_DB_NAME = "db-users";

    public static final String FLIGHTS_DB_NAME = "db-flights";

    public static final String LOG_RECORDS_DB_NAME = "db-logRecords";

    public static final String USERS_TABLE = "users";

    public static final String FLIGHTS_TABLE = "flights";

    public static final String LOG_RECORDS_TABLE = "logrecords";

//    public abstract ImperialAirCharterDAO getUserDAO();
//
//    public abstract  ImperialAirCharterDAO getLogRecordDAO();
//
//    public abstract ImperialAirCharterDAO getFlightDAO();
}


