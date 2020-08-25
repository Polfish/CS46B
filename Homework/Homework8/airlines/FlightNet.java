package Homework.Homework8.airlines;

import java.util.HashSet;

public class FlightNet extends HashSet<Airport> {

    //Returns true if the FlightNet does not contain an airport with the given name
    public boolean nameIsAvailable(String name) {
        for (Airport a : this) {
            if (a.getName().equals(name)) {
                return false;
            }
        }

        return true;
    }

    //Connects a1 and a2 in both directions
    public void connect(Airport a1, Airport a2) {
        a1.connectTo(a2);
        a2.connectTo(a1);
    }

    //Disconnects a1 and a2 in both directions
    public void disconnect(Airport a1, Airport a2) {
        a1.disconnectFrom(a2);
        a2.disconnectFrom(a1);
    }

    //Removes removeMe from this FlightNet
    //Then, disconnects any flight it is connected to in the FlightNet
    public void removeAndDisconnect(Airport removeMe) {
        this.remove(removeMe);

        for (Airport a : this) {
            if (a.isConnectedTo(removeMe)) {
                removeMe.disconnectFrom(a);
            }
        }
    }

    //Gets the first airport that is within the maximum distance of the given x and y
    public Airport getAirportNearXY(int x, int y, int maximumDistance) {
        for (Airport a : this) {
            if (Math.hypot(x - a.getX(), y - a.getY()) <= maximumDistance) {
                return a;
            }
        }

        return null;
    }

}
