package edu.gatech.cs2340.spacetraders.model;
/**
 * This is the interface to the domain/business classes from anywhere else in the application
 *
 *
 * This class provides the player for the application.
 *
 * It is a Singleton so that it can be accessed from anywhere in the application
 */
public class ModelFacade {
    private Game myGame;
    /** Singleton Pattern Code
     *  this allows us to get access to this class
     *  anywhere, which will allow our View models to access
     *  the "back end"  more easily
     */
    private static final ModelFacade ourInstance = new ModelFacade();

    public static ModelFacade getInstance() {
        return ourInstance;
    }
    /**
     * Make a new Model instance (should have parameters of the data entered by the player)
     */
    private ModelFacade() {
    }

    public void setGame(Game a) {
        myGame = a;
    }
    public Game getGame() {
        return myGame;
    }
}
