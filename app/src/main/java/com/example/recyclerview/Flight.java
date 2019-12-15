package com.example.recyclerview;

public class Flight {
    private String flightNumber;
    private String departure;
    private String arrival;
    private String departureTime;
    private int capacity;
    private double price;

    public Flight(String flightNumber, String departure, String arrival, String departureTime, int capacity, double price) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.price = price;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
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
    @Override
    public String toString() {
        String result = "Flight Number: " + flightNumber +
                "\n    Departure: " + departure +
                "\n    Arrival: " + arrival +
                "\n    Departure Time: " + departureTime +
                "\n    Capacity: " + capacity +
                "\n    Price: " + price + "\n\n";
        return result;
    }
}
