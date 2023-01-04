package com.kodilla.exception.test;

import java.util.HashMap;

public class FlightFinderRunner {
    public static void main(String[] args) {
        HashMap<String, Boolean> flightsFromWAW = new HashMap();
        flightsFromWAW.put("CDG", true);
        flightsFromWAW.put("LHR", true);
        flightsFromWAW.put("FRA", true);
        flightsFromWAW.put("AMS", true);
        flightsFromWAW.put("LAX", false);
        flightsFromWAW.put("SYD", false);

        FlightFinder finder = new FlightFinder(flightsFromWAW);
        Flight flights[] = {
                new Flight("WAW","CDG"),
                new Flight("WAW", "LHR"),
                new Flight("WAW","FRA"),
                new Flight("WAW","AMS"),
                new Flight("WAW","LAX"),
                new Flight("WAW","SYD")
        };

        for(Flight f : flights) {
            try {
                finder.findFlight(f);
            } catch (RouteNotFoundException e) {
                //the appropriate message handled by the class RouteNotFoundException
            }
        }
    }
}
