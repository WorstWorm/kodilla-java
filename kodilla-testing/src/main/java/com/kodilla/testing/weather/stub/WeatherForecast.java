package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }

    public double calculateAvarage(){
        double result = 0.0;
        for(Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()){
            result += entry.getValue();
        }
        result = result/ temperatures.getTemperatures().size();
        return result;
    }

    public double calculateMedian(){
        ArrayList<Double> tempList = new ArrayList<>();
        for(Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()){
            tempList.add(entry.getValue());
        }
        Collections.sort(tempList);
        int index = tempList.size()/2;
        return tempList.get(index);
    }




}