package edu.gatech.cs2340.spacetraders.model;

public enum DifficultyStanding {
    EASY("EASY"), MEDIUM("MEDIUM"), HARD("HARD");
    private final String standing;
    DifficultyStanding(String standing) {
        this.standing = standing;
    }
    @Override public String toString(){
        return standing;
    }
}
