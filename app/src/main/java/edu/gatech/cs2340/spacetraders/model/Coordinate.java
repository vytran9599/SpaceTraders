package edu.gatech.cs2340.spacetraders.model;

public class Coordinate {
    private int x;
    private int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public boolean equals(Object other) {
        Coordinate coord = (Coordinate) other;
        return coord.getX() == x && coord.getY() == y;
    }
}
