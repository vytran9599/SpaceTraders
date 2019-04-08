package edu.gatech.cs2340.spacetraders.model;

/**
 * Difficulty Standing enums
 */
public enum DifficultyStanding {
    BEGINNER("Beginner"), EASY("Easy"), NORMAL("Normal"), HARD("Hard"), EXPERT("Expert");
    private final String standing;
    DifficultyStanding(String standing) {
        this.standing = standing;
    }
}