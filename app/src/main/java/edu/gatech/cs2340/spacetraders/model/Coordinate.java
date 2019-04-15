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
     * Constructor of Coordinate
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
        if (!(other instanceof Coordinate)) {
            return false;
        }
        Coordinate coordinate = (Coordinate) other;
        return (coordinate.getX() == x) && (coordinate.getY() == y);
    }

    /**
     * To string override
     * @return String
     */
    @Override
    public String toString() {
        return "Coordinate: (" + x + ", " + y + "). ";
    }
}
