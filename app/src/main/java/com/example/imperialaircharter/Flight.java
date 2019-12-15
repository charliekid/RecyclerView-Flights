package com.example.imperialaircharter;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.imperialaircharter.DB.AppDatabase;

@Entity(tableName = AppDatabase.FLIGHTS_TABLE)

public class Flight {
    @PrimaryKey(autoGenerate =  true)
    private int flightId;
    private String flightNumber;
    private String departure;
    private String arrival;
    private String departureTime;
    private int capacity;
    private double price;

    public Flight() {

    }

    @Ignore
    public Flight(String flightNumber, String departure, String arrival, String departureTime, int capacity, double price) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.price = price;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        String result = "Flight Number: " + flightNumber +
                        "\n    Departure: " + departure +
                        "\n    Arrival: " + arrival +
                        "\n    Departure Time: " + departureTime +
                        "\n    Capacity: " + capacity +
                        "\n    Price: " + price + "\n\n";
//        return "Flight{" +
//                "Flight Number: '" + flightNumber + '\'' +
//                "Departure: '" + departure + '\'' +
//                "Arrival:'" + arrival + '\'' +
//                "Departure Time:'" + departureTime + '\'' +
//                "Capacity: " + capacity +
//                "Price: " + price +
//                '}';
        return result;
    }
}
