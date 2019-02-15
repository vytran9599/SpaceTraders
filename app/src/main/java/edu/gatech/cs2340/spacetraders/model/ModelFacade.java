package edu.gatech.cs2340.spacetraders.model;

public class ModelFacade {
    private static final ModelFacade ourInstance = new ModelFacade();

    public static ModelFacade getInstance() {
        return ourInstance;
    }

    private ModelFacade() {
    }
}
