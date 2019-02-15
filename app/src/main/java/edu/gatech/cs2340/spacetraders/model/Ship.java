package edu.gatech.cs2340.spacetraders.model;

public class Ship {
    private ShipType shipType;

    /**
     * The default constructor for ship. When the ship is initially created
     * It has the ship type of NAT
     */
    public Ship() {
        shipType = ShipType.GNAT;
    }

    /**
     * Getter method for the ship type
     * @return the ship type of this ship
     */
    public ShipType getShipType() {
        return shipType;
    }

    /**
     * Setter method for the ship type
     * @param newType the new ship type of this ship
     */
    public void setShipType(ShipType newType) {
        shipType = newType;
    }
}
