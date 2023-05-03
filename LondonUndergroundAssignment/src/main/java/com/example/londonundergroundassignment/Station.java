package com.example.londonundergroundassignment;

public class Station {
    String stationName;
    String lineName;
    String colour;
    double x;
    double y;

    public Station(String stationName, String lineName, String colour, double x, double y) {
        this.stationName = stationName;
        this.lineName = lineName;
        this.colour = colour;
        this.x = x;
        this.y = y;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getColor() {
        return colour;
    }

    public void setColor(String color) {
        this.colour = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationName='" + stationName + '\'' +
                ", lineName='" + lineName + '\'' +
                ", color='" + colour + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}



