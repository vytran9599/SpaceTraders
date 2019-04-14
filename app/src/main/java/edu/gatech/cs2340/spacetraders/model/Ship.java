package edu.gatech.cs2340.spacetraders.model;

import android.util.Log;

/**
 * Ship class
 */
public class Ship {
    private ShipType shipType;
    private int maxCapacity;
    private int capacity;
    private int fuel;
    private int fuelCapacity;

    /**
     * constructor
     * @param p integer
     */
    public Ship(int p) {
        shipType = ShipType.GNAT;
        maxCapacity = 20;
        capacity = 0;
        fuelCapacity = p * 25 + 25;
        fuel = p * 25 + 25;
    }

    /**
     * Getter method for the ship type
     * @return the ship type of this ship
     */
    public ShipType getShipType() {
        return shipType;
    }

    /**
     * setter fuel
     * @param f integer
     */
    public void setFuel(int f) {
        fuel = f;
    }

    /**
     * getter fuel
     * @return integer
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * getter fuel
     * @return integer
     */
    public int getFuelCapacity() {
        return fuelCapacity;
    }

    /**
     * getter capacity
     * @return integer
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * setter for capacity
     * @param c integer
     */
    public void setCapacity(int c) {
        capacity = c;
        Log.d("entered setCapacity() "," new capacity: " + capacity);
    }

    /**
     * getter capacity
     * @return integer
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * setter max
     * @param m integer
     */
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
