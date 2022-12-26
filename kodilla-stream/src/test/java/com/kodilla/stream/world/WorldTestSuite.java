package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {

        //Given
        World world = new World();
        Continent primis = new Continent();
        Continent secundo = new Continent();
        Continent tertius = new Continent();
        world.addContinent(primis);
        world.addContinent(secundo);
        world.addContinent(tertius);
        Country erste = new Country(new BigDecimal("111111111111111"));
        Country sekunde = new Country(new BigDecimal("222222222222222"));
        Country dritte = new Country(new BigDecimal("333333333333333"));
        Country vierte = new Country(new BigDecimal("111111111111111"));
        Country funfte = new Country(new BigDecimal("222222222222222"));
        Country sechste = new Country(new BigDecimal("111111111111111"));
        Country siebte = new Country(new BigDecimal("222222222222222"));
        primis.addCountry(erste);
        primis.addCountry(sekunde);
        primis.addCountry(dritte);
        secundo.addCountry(vierte);
        secundo.addCountry(funfte);
        tertius.addCountry(sechste);
        tertius.addCountry(siebte);

        //When
        BigDecimal totalPopulation = world.getPeopleQuantity();
        BigDecimal expectedPopulation = new BigDecimal("1333333333333332");

        //Then
        assertEquals(expectedPopulation, totalPopulation);

    }
}
