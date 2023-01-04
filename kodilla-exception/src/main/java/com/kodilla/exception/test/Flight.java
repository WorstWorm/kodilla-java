package com.kodilla.exception.test;

public class Flight {

    private String departureAirport;
    private String arrivalAirport;

    public Flight(String departure, String arrival){
        this.departureAirport = departure;
        this.arrivalAirport = arrival;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }
}
