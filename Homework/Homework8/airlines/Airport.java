package Homework.Homework8.airlines;

import java.util.*;


public class Airport implements Comparable<Airport> {

    private String name;
    private int x;
    private int y;
    private Set<Airport> connections;    // all airports with a direct route from this airport


    public Airport(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
        connections = new TreeSet<>();
    }


    public String getName() {
        return name;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public List<Airport> getConnections() {
        return new ArrayList<>(connections);
    }


    // Adds that airport to the list of connections. This is a one-way route, so
    // don’t add this airport to that’s list of connections.
    public void connectTo(Airport that) {
        connections.add(that);
    }


    //
    // Does nothing if this airport is not connected to that.
    //
    public void disconnectFrom(Airport that) {
        if (isConnectedTo(that)) {
            connections.remove(that);
        }
    }

    // Use best practice.
    @Override
    public boolean equals(Object o) {
        Airport that = (Airport) o;
        if (this.compareTo(that) == 0) {
            return true;
        }

        return false;
    }

    // Just compare by airport name.
    public int compareTo(Airport that) {
        return name.compareTo(that.name);
    }

    public boolean isConnectedTo(Airport that) {
        return connections.contains(that);
    }

    public String toString() {
        return "Airport " + name + " @(" + x + "," + y + ")";
    }

}
