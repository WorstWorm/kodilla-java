package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    private final HashMap<String, Boolean> flightMap;

    public FlightFinder(HashMap flightMap){
        this.flightMap = flightMap;
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        boolean flag = false;
        for(Map.Entry<String, Boolean> entry : flightMap.entrySet()) {
            if(entry.getKey().equals(flight.getArrivalAirport()) && entry.getValue()) {
                System.out.println("There is connection from " + flight.getDepartureAirport() + " to " + entry.getKey());
                flag = true;
            }
        }
        if(!flag) {
            throw new RouteNotFoundException(flight);
        }
    }
}
