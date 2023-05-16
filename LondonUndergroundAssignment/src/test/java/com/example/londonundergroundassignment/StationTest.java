package com.example.londonundergroundassignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {
    private Station station1;
    private Station station2;
    private Station station3;
    private Stationline stationline1;

    @BeforeEach
    public void setUp() {
        station1 = new Station("Station1", 1.0, 1.0);
        station2 = new Station("Station2", 2.0, 2.0);
        station3 = new Station("Station3", 3.0, 3.0);
    }

    @Test
    public void testConstructor() {
        assertEquals("Station1", station1.getStationName());
        assertEquals(1.0, station1.getXcoord());
        assertEquals(1.0, station1.getYcoord());
        assertTrue(station1.getNeighborStations().isEmpty());
        assertTrue(station1.getLines().isEmpty());
        assertEquals(Double.MAX_VALUE, station1.getDistanceFromFirstStation());
        assertNull(station1.getPreviousStation());
    }

    @Test
    public void testSettersAndGetters() {
        station1.setStationName("NewStation1");
        assertEquals("NewStation1", station1.getStationName());

        station1.setXcoord(4.0);
        assertEquals(4.0, station1.getXcoord());

        station1.setYcoord(4.0);
        assertEquals(4.0, station1.getYcoord());

        station1.setDistanceFromFirstStation(10.0);
        assertEquals(10.0, station1.getDistanceFromFirstStation());

        station1.setPreviousStation(station2);
        assertEquals(station2, station1.getPreviousStation());
    }

    @Test
    public void testAddNeighbor() {
        station1.addNeighbor(station2);
        assertEquals(1, station1.getNeighborStations().size());
        assertTrue(station1.getNeighborStations().containsKey(station2));
        assertEquals(Math.sqrt(2), station1.getNeighborStations().get(station2));
    }

    @Test
    public void testCalculateDistanceTo() {
        double distance = station1.calculateDistanceTo(station2);
        assertEquals(Math.sqrt(2), distance);
    }

    @Test
    public void testAddLine() {
        station1.addLine(stationline1);
        assertEquals(1, station1.getLines().size());
        assertTrue(station1.getLines().contains(stationline1));
    }

    @Test
    public void testToString() {
        station1.addNeighbor(station2);
        station1.addNeighbor(station3);
        String expectedOutput = "Station: Name: Station1, xCoordinate: 1.0, yCoordinate: 1.0, neighboring stations: Station2, Station3";
        assertEquals(expectedOutput, station1.toString());
    }


}