package com.example.imperialaircharter.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.imperialaircharter.Flight;
import com.example.imperialaircharter.LogRecord;
import com.example.imperialaircharter.User;
//import com.example.imperialaircharter.Flight;
//import com.example.imperialaircharter.LogRecord;

@Dao
public interface ImperialAirCharterDAO {

    //User stuff
    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User... users);

    @Query("SELECT * FROM " + AppDatabase.USERS_TABLE)
    List<User> getAllUsers();

    //User login(String username, String password);

    @Query("SELECT * FROM " + AppDatabase.USERS_TABLE + " WHERE username = :username")
    User getUsername(String username);

    @Insert
    void addUser(User user);


    // flight stuff
    @Query("SELECT * FROM " + AppDatabase.FLIGHTS_TABLE)
    List<Flight> getAllFlights();
    //List<Flight> searchFlight(String departure, String arrival);
    @Insert
    void addFlight(Flight flight);
    //void updateFlight(Flight flight);
    // log record stuff
    // List<LogRecord> getAllLogRecords();
    // void addLog(LogRecord logRecord);

    //Log Record stuff
    @Insert
    void addLogRecord(LogRecord logRecord);

    @Query("SELECT * FROM " + AppDatabase.LOG_RECORDS_TABLE)
    List<LogRecord> getAllLogRecords();
}
