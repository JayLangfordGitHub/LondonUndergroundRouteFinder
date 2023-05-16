package com.example.londonundergroundassignment;

public class ConnectStations {
    public GraphNode<?> destNode; // represents the node that the edge is directed towards
    public int cost;

    public ConnectStations(GraphNode<?> destNode, int cost) {
        this.destNode =destNode;
        this.cost=cost;
    }
}
