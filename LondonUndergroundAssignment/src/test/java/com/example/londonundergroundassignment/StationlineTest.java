package com.example.londonundergroundassignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationlineTest {
    private Stationline line1;
    private Station station1;
    private Station station2;

    @BeforeEach
    public void setUp() {
        line1 = new Stationline("Line1", "Red");
        station1 = new Station("Station1", 1.0, 1.0);
        station2 = new Station("Station2", 2.0, 2.0);
    }

    @Test
    public void testConstructor() {
        assertEquals("Line1", line1.getLineName());
        assertEquals("Red", line1.getLineColor());
        assertTrue(line1.getStations().isEmpty());
    }

    @Test
    public void testAddStation() {
        line1.addStation(station1);
        assertEquals(1, line1.getStations().size());
        assertTrue(line1.getStations().contains(station1));
        assertTrue(station1.getLines().contains(line1));
    }

}