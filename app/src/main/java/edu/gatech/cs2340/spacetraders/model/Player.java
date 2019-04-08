package edu.gatech.cs2340.spacetraders.model;

import android.util.Log;

//import java.util.HashMap;

/**
 * Player class
 */
@SuppressWarnings("unused")
public class Player {
    //added final
    private final String name;
    private final int pilotPts, engrPts, tradePts, fightPts;
    private int credit;
    private Ship myShip;
    private final DifficultyStanding difficulty;
    private final int[] personalGoodCounts;
    private final TradeGood[] goods = {
            new TradeGood("Water", 0, 0, 2, 3, 4, Condition.DROUGHT, Resources.LOTSOFWATER,
                    Resources.DESERT, 30, 50, 30 ),
            new TradeGood("Furs", 0, 0, 0, 10, 10, Condition.COLD, Resources.RICHFAUNA,
                    Resources.LIFELESS, 230, 280, 250),
            new TradeGood("Food", 1, 0, 1, 5, 5, Condition.CROPFAIL, Resources.RICHSOIL,
                    Resources.POORSOIL, 90, 160, 100),
            new TradeGood("Ore", 2, 2, 3, 20, 10, Condition.WAR, Resources.MINERALRICH,
                    Resources.MINERALPOOR, 350, 420, 350),
            new TradeGood("Games", 3, 1, 6, -10, 5, Condition.BOREDOM,
                    Resources.ARTISTIC, null, 160, 270, 250),
            new TradeGood("Firearms", 3, 1, 5, -75, 100, Condition.WAR,
                    Resources.WARLIKE, null, 600, 1100, 1250),
            new TradeGood("Medicine", 4, 1, 6, -20, 10, Condition.PLAGUE,
                    Resources.LOTSOFHERBS, null, 400, 700, 650),
            new TradeGood("Machines", 4, 3, 5, -30, 5, Condition.LACKOOFWORKERS,
                    null, null, 600, 800, 900),
            new TradeGood("Narcotics", 5, 0, 5, -125, 150, Condition.BOREDOM,
                    Resources.WEIRDMUSHROOMS, null, 2000, 3000, 3500),
            new TradeGood("Robots", 6, 4, 7, -150, 100, Condition.LACKOOFWORKERS,
                    null, null, 3500, 5000, 5000)
    };

    /**
     *
     * @param name name
     * @param difficulty difficulty
     * @param pilotPts pilot points
     * @param engrPts engineer points
     * @param tradePts trade points
     * @param fightPts fight points
     */
    public Player(String name, DifficultyStanding difficulty, int pilotPts,
                  int engrPts,
                  int tradePts, int fightPts) {
        this.name = name;
        this.difficulty = difficulty;
        this.pilotPts = pilotPts;
        this.engrPts = engrPts;
        this.tradePts = tradePts;
        this.fightPts = fightPts;
        credit = 1000;
        myShip = new Ship(pilotPts);
        personalGoodCounts = new int[goods.length];
    }

    /**
     * has good
     * @param goodName string
     * @return boolean
     */
    public boolean hasGood(String goodName) {
        int index = getIndexByName(goodName);
        if (index < 0 || index >= personalGoodCounts.length) {
            return false;
        }
        return personalGoodCounts[index] > 0;
    }

    /**
     * less good
     * @param good trade good
     */
    public void lessGood(TradeGood good) {
        int index = getIndexByName(good.getName());
        if (index >= 0 && index < goods.length) {
            if (personalGoodCounts[index] > 0) {
                personalGoodCounts[index]--;
                credit = credit + good.getFinalPrice();
                myShip.setCapacity(myShip.getCapacity() - 1);
            }
        }
    }

    /**
     * more good
     * @param good trade good
     */
    public void moreGood(TradeGood good) {
        int index = getIndexByName(good.getName());
        if (index >= 0 && index < goods.length && myShip.getCapacity() < myShip.getMaxCapacity()) {
                personalGoodCounts[index]++;
                myShip.setCapacity(myShip.getCapacity() + 1);
                credit = credit - good.getFinalPrice();
                Log.d("entered moreGood", "More " + good.getName());
        }
    }

    /**
     * getting for personal good
     * @return int array
     */
    public int[] getPersonalGoodCounts() {
        return personalGoodCounts;
    }

    //was public

    /**
     * getters for index of name
     * @param n name
     * @return integer
     */
    private int getIndexByName(String n) {
        for (int i = 0; i < goods.length; i++) {
            if (goods[i].getName().equals(n)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * have space
     * @return my ship capacity
     */
    public boolean haveSpace() {
        return myShip.getCapacity() < myShip.getMaxCapacity();
    }


    /**
     * getter method for player's name
     * @return the name of the player
     */
    public String getName(){
        return name;
    }
// --Commented out by Inspection START (4/7/19, 11:27 PM):
//    /**
//     * getter method for player's pilot points
//     * @return the pilot points of the player
//     */
//    public int getPilotPts(){
//        return pilotPts;
//    }
// --Commented out by Inspection STOP (4/7/19, 11:27 PM)
// --Commented out by Inspection START (4/7/19, 11:27 PM):
//// --Commented out by Inspection START (4/7/19, 11:27 PM):
////    /**
////     * getter method for player's engineer points
////     * @return the engineer points of the player
////     */
////    public int getEngrPts(){
// --Commented out by Inspection STOP (4/7/19, 11:27 PM)
//        return engrPts;
//    }
// --Commented out by Inspection STOP (4/7/19, 11:27 PM)
    /**
// --Commented out by Inspection START (4/7/19, 11:27 PM):
// --Commented out by Inspection START (4/7/19, 11:27 PM):
////     * getter method for player's trade points
////     * @return the trade points of the player
////     */
////    public int getTradePts(){
////        return tradePts;
// --Commented out by Inspection START (4/7/19, 11:27 PM):
//// --Commented out by Inspection STOP (4/7/19, 11:27 PM)
////    }
////    /**
////     * getter method for player's fight points
//// --Commented out by Inspection STOP (4/7/19, 11:27 PM)
// --Commented out by Inspection STOP (4/7/19, 11:27 PM)
     * @return the fight points of the player
     */
    public int getFightPts(){
        return fightPts;
    }
    /**
     * getter method for player's credit
     * @return the credit of the player
     */
    public int getCredit(){
        return credit;
    }

    /**
     * set credits
     * @param a integer
     */
    public void setCredit(int a) {
        credit = a;
    }

    /**
     * getter for ship
     * @return ship
     */
    public Ship getMyShip() {
        return myShip;
    }

    /**
     * setter for ship
     * @param s ship
     */
    public void setMyShip(Ship s) {
        myShip = s;
    }

    /**
     * The toString of player
     * @return the string representation of a player
     */
    @Override
    public String toString() {
        return String.format(
                "Name: %s, pilot points: %d, engineer points: %d, "
                        + "trade points: %d, fight points: %d, credit: %d, ship: %s",
                name, pilotPts, engrPts, tradePts, fightPts, credit,
                myShip.getShipType().toString());
    }
}