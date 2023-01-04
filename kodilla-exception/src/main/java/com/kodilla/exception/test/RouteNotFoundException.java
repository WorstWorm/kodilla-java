package com.kodilla.exception.test;

public class RouteNotFoundException extends Exception {
    public RouteNotFoundException(Flight f) {
        System.out.println("There is no connection from " + f.getDepartureAirport() + " to " + f.getArrivalAirport());
    }
}
