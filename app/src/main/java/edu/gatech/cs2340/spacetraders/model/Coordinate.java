package edu.gatech.cs2340.spacetraders.model;

/**
 * Coordinate class
 */
public class Coordinate {
    //added final
    private final int x;
    //added final
    private final int y;

    /**
     * Constructor of Coodinate
     * @param x integer x
     * @param y integer y
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getters for x
     * @return integer
     */
    public int getX() {
        return x;
    }

    /**
     * Getters for y
     * @return integer
     */
    public int getY() {
        return y;
    }
    @Override
    public boolean equals(Object other) {
        Coordinate coord = (Coordinate) other;
        return coord.getX() == x && coord.getY() == y;
    }
    @Override
    /**
     *
     * To string
     */
    public String toString() {
        return "Coordinate: (" + x + ", " + y + "). ";
    }
}
