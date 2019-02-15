package edu.gatech.cs2340.spacetraders.model;

public abstract class Player {
    private DifficultyStanding ds;
    public Player(DifficultyStanding ds) {
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
