package edu.gatech.cs2340.spacetraders.model;

public class Game {
    private DifficultyStanding ds;
    public Game(DifficultyStanding ds) {
        this.ds = ds;
    }
    public void setDS(DifficultyStanding ds) {
        this.ds = ds;
    }
    public DifficultyStanding getDS() {
        return ds;
    }
    @Override
    public String toString() {
        return String.format("Difficulty standing: %s", ds);
    }
}
