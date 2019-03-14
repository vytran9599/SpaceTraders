package edu.gatech.cs2340.spacetraders.model;

import android.util.Log;

public class Ship {
    private ShipType shipType;
    private int maxCapacity;
    private int capacity;

    /**
     * The default constructor for ship. When the ship is initially created
     * It has the ship type of GNAT
     */
    public Ship() {
        shipType = ShipType.GNAT;
        maxCapacity = 20;
        capacity = 0;
    }

    /**
     * Getter method for the ship type
     * @return the ship type of this ship
     */
    public ShipType getShipType() {
        return shipType;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int c) {
        capacity = c;
        Log.d("entered setCapacity() "," new capacity: " + capacity);
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    public void setMaxCapacity(int m) {
        maxCapacity = m;
    }

    /**
     * Setter method for the ship type
     * @param newType the new ship type of this ship
     */
    public void setShipType(ShipType newType) {
        shipType = newType;
    }


}
