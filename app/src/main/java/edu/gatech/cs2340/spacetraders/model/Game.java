package edu.gatech.cs2340.spacetraders.model;

import android.util.Log;

/**
 * Game class
 */
public class Game implements java.io.Serializable{
    private final DifficultyStanding ds;
    //added final
    private final Player thisPlayer;
    //added final
    private final Universe myUniverse;

    /**
     * Game constructor
     */
    public Game() {
        this(DifficultyStanding.EASY, new Player("Bob",DifficultyStanding.EASY,
                4, 4, 4, 4), new Universe());
    }

    /**
     /* *
     * Constructor
     * @param ds difficulty standing
     * @param player player
     * @param u universe
     */
    public Game(DifficultyStanding ds, Player player, Universe u) {
        Log.d("game created","yuh yuh");
        this.ds = ds;
        thisPlayer = player;
        myUniverse = u;
    }


    /*
      setter method for the difficulty standing of this game
      @param ds the new difficulty standing
     */
  //  public void setDS(DifficultyStanding ds) {
   //     this.ds = ds;
  //  }

    /**
     * the getter method for the difficulty standing of this game
     * @return the difficulty standing of this game
     */
 //   public DifficultyStanding getDS() {
      //  return ds;
   // }

    /**
     * Get Universe
     * @return Universe
     */
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
