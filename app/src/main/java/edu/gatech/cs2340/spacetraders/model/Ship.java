package edu.gatech.cs2340.spacetraders.model;


/**
 * Ship class
 */
public final class Ship {
    private ShipType shipType;
    private final int maxCapacity;
    private int capacity;
    private int fuel;

    /**
     * constructor
     * @param p integer
     */
    public Ship(int p) {
        shipType = ShipType.GNAT;
        maxCapacity = 20;
        capacity = 0;
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
        //Log.d("entered setCapacity() "," new capacity: " + capacity);
    }

    /**
     * getter capacity
     * @return integer
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

// --Commented out by Inspection START (4/7/19, 11:27 PM):
//    /**
//     * setter max
//     * @param m integer
//     */
// --Commented out by Inspection START (4/7/19, 11:27 PM):
////    public void setMaxCapacity(int m) {
////        maxCapacity = m;
////    }
//// --Commented out by Inspection STOP (4/7/19, 11:27 PM)
//
//    /**
//     * Setter method for the ship type
//     * @param newType the new ship type of this ship
// --Commented out by Inspection STOP (4/7/19, 11:27 PM)

    /**
     * set ship type
     * @param newType ship type
     */
    public void setShipType(ShipType newType) {
        shipType = newType;
    }


}
