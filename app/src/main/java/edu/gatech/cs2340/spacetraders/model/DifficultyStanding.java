package edu.gatech.cs2340.spacetraders.model;

public enum DifficultyStanding {
    EASY("Easy"), MEDIUM("Medium"), HARD("Hard"), EXPERT("Expert");
    private final String standing;
    DifficultyStanding(String standing) {
        this.standing = standing;
    }
}