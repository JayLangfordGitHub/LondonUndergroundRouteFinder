package com.example.londonundergroundassignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Station {
    private String stationName; // The name of the station
    private double xcoord; // The xcoord-coordinate of the station
    private double ycoord; // The ycoord-coordinate of the station
    private Map<Station, Double> neighborStations; // A map of neighboring stations and their distances
    private List<Double> distances; // A list of distances to the neighborStations
    private List<Stationline> lines; // A list of lines that the station is on
    private double distanceFromFirstStation = Double.MAX_VALUE; // Distance from the start station for Dijkstra's algorithm
    private Station previousStation; // Previous station in the shortest path from the start station

    // CONSTRUCTOR
    public Station(String stationName, double x, double y) {
        this.stationName = stationName; // Initialize the station with a name
        this.xcoord = x; // Initialize the xcoord-coordinate of the station
        this.ycoord = y; // Initialize the ycoord-coordinate of the station
        this.neighborStations = new HashMap<>(); // Initialize the map of neighborStations as an empty HashMap
        this.distances = new ArrayList<>(); // Initialize the list of distances as an empty ArrayList
        this.lines = new ArrayList<>(); // Initialize the list of lines as an empty ArrayList
    }

    // GETTERS
    public String getStationName() {
        return stationName; // Get the name of the station
    }

    public double getXcoord() {
        return xcoord; // Get the xcoord-coordinate of the station
    }

    public double getYcoord() {
        return ycoord; // Get the ycoord-coordinate of the station
    }

    public Map<Station, Double> getNeighborStations() {
        return neighborStations; // Get the map of neighboring stations and their distances
    }

    public List<Stationline> getLines() {
        return lines; // Get the list of lines that the station is on
    }

    public double getDistanceFromFirstStation() {
        return distanceFromFirstStation; // Get the distance from the start station
    }

    public Station getPreviousStation() {
        return previousStation; // Get the previous station in the shortest path from the start station
    }

    // SETTERS
    public void setStationName(String stationName) {
        this.stationName = stationName; // Set the name of the station
    }

    public void setXcoord(double xcoord) {
        this.xcoord = xcoord; // Set the xcoord-coordinate of the station
    }

    public void setYcoord(double ycoord) {
        this.ycoord = ycoord; // Set the ycoord-coordinate of the station
    }

    public void setNeighborStations(Map<Station, Double> neighborStations) {
        this.neighborStations = neighborStations; // Set the map of neighboring stations and their distances
    }

    public void setDistanceFromFirstStation(double distanceFromFirstStation) {
        this.distanceFromFirstStation = distanceFromFirstStation; // Set the distance from the start station
    }

    public void setPreviousStation(Station previousStation) {
        this.previousStation = previousStation; // Set the previous station in the shortest path from the start station
    }
    public void addNeighbor(Station neighbor) {
        double distance = this.calculateDistanceTo(neighbor); // Calculate the distance between this station and the neighbor
        this.neighborStations.put(neighbor, distance); // Add the neighboring station and its distance to the map of neighborStations
        distances.add(distance); // Add the distance to the list of distances
    }
    public double calculateDistanceTo(Station other) {
        return Math.sqrt(Math.pow((this.xcoord - other.getXcoord()), 2) + Math.pow((this.ycoord - other.getYcoord()), 2));
    }

    public void addLine(Stationline line) {
        this.lines.add(line); // Add a line to the list of lines
    }

    @Override
    public String toString() {
        String neighborNames = neighborStations.keySet().stream()
                .map(Station::getStationName)
                .collect(Collectors.joining(", "));

        return "Station: " + "Name: " + stationName + ", xCoordinate: " + xcoord + ", yCoordinate: " + ycoord + ", neighboring stations: " + neighborNames;
    }
}



