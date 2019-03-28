package edu.gatech.cs2340.spacetraders.model;

import android.util.Log;

public class Game {
    private DifficultyStanding ds;
    private Player thisPlayer;
    private Universe myUniverse;
    public Game() {
        this(DifficultyStanding.EASY, new Player("Bob",DifficultyStanding.EASY,4, 4, 4, 4), new Universe());
    }
    /**
     * The constructor of game
     * @param ds the difficulty standing of this game
     * @param player the player of this game
     */
    public Game(DifficultyStanding ds, Player player, Universe u) {
        Log.d("game created","yuh yuh");
        this.ds = ds;
        thisPlayer = player;
        myUniverse = u;
    }


    /**
     * setter method for the difficulty standing of this game
     * @param ds the new difficulty standing
     */
    public void setDS(DifficultyStanding ds) {
        this.ds = ds;
    }

    /**
     * the getter method for the difficulty standing of this game
     * @return the difficulty standing of this game
     */
    public DifficultyStanding getDS() {
        return ds;
    }
    public Universe getMyUniverse() {
        return myUniverse;
    }

    /**
     * the toString of the game
     * @return the string representation of the game including difficulty standing and player info
     */
    @Override
    public String toString() {
        return String.format("Difficulty standing: %s, player: %s", ds, thisPlayer);
    }

    /**
     * getter method for player
     * @return player
     */
    public Player getPlayer() { return thisPlayer; }
}
