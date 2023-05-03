package com.example.londonundergroundassignment;

import java.util.*;

public class Graph {
    Map<String, Station> stations;
    Map<String, List<String>> adjacencyList;

    public Graph() {
        stations = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    public void addStation(Station station) {
        stations.put(station.stationName, station);
        adjacencyList.put(station.stationName, new ArrayList<>());
    }

    public void addEdge(String station1, String station2) {
        adjacencyList.get(station1).add(station2);
        adjacencyList.get(station2).add(station1);
    }

    // DFS
    public List<String> dfs(String startStation, String destinationStation) {
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parentMap = new HashMap<>();

        stack.push(startStation);
        visited.add(startStation);

        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (current.equals(destinationStation)) {
                return constructPath(parentMap, startStation, destinationStation);
            }

            for (String neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        return null; // No path found
    }

    // BFS
    public List<String> bfs(String startStation, String destinationStation) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parentMap = new HashMap<>();

        queue.offer(startStation);
        visited.add(startStation);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(destinationStation)) {
                return constructPath(parentMap, startStation, destinationStation);
            }

            for (String neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        return null; // No path found
    }

    // Dijkstra's Algorithm
    public List<String> dijkstra(String startStation, String destinationStation) {
        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        Set<String> unvisited = new HashSet<>();

        for (String station : adjacencyList.keySet()) {
            distances.put(station, Double.MAX_VALUE);
            unvisited.add(station);
        }

        distances.put(startStation, 0.0);

        while (!unvisited.isEmpty()) {
            String current = getClosestStation(unvisited, distances);
            unvisited.remove(current);

            if (current.equals(destinationStation)) {
                return constructPath(previous, startStation, destinationStation);
            }

            for (String neighbor : adjacencyList.get(current)) {
                double tentativeDist = distances.get(current) + distanceBetween(current, neighbor);

                if (tentativeDist < distances.get(neighbor)) {
                    distances.put(neighbor, tentativeDist);
                    previous.put(neighbor, current);
                }
            }
        }

        return null; // No path found
    }

    private List<String> constructPath(Map<String, String> parentMap, String start, String destination) {
        List<String> path = new ArrayList<>();
        String current = destination;

        while (current != null) {
            path.add(0, current);
            current = parentMap.get(current);
        }

        return path;
    }
    private String getClosestStation(Set<String> unvisited, Map<String, Double> distances) {
        String closestStation = null;
        double minDistance = Double.MAX_VALUE;

        for (String station : unvisited) {
            double distance = distances.get(station);
            if (distance < minDistance) {
                minDistance = distance;
                closestStation = station;
            }
        }

        return closestStation;
    }
    private double distanceBetween(String station1, String station2) {
        Station s1 = stations.get(station1);
        Station s2 = stations.get(station2);

        double lat1 = Math.toRadians(s1.y);
        double lon1 = Math.toRadians(s1.x);
        double lat2 = Math.toRadians(s2.y);
        double lon2 = Math.toRadians(s2.x);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Radius of Earth in meters
        final int R = 6371 * 1000;

        return R * c;
    }


}
