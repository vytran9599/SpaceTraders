package edu.gatech.cs2340.spacetraders.model;

public enum DifficultyStanding {
<<<<<<< HEAD
    EASY("Easy"), MEDIUM("Medium"), HARD("Hard"), EXPERT("Expert");
=======
    EASY("EASY"), MEDIUM("MEDIUM"), HARD("HARD");
>>>>>>> master
    private final String standing;
    DifficultyStanding(String standing) {
        this.standing = standing;
    }
    @Override public String toString(){
        return standing;
    }
}
