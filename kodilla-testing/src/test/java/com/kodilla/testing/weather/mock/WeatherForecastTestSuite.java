package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {
    Map<String, Double> temperaturesMap = new HashMap<>(){{put("Rzeszow", 25.5);
        put("Krakow", 26.2);put("Wroclaw", 24.8);put("Warszawa", 25.2);put("Gdansk", 26.1);}};

    @Mock
    private Temperatures temperaturesMock;


    @Test
    void testCalculateForecastWithMock() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    void calculateAvarage(){
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double avarage = weatherForecast.calculateAvarage();

        //Then
        Assertions.assertEquals(25.56, avarage);
    }

    @Test
    void calculateMedian(){
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double median = weatherForecast.calculateMedian();

        //Then
        Assertions.assertEquals(25.5, median);
    }
}