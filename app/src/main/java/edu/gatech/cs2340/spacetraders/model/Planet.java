package edu.gatech.cs2340.spacetraders.model;


public class Planet {
    private String name;
    private Market thisMarket;

    public Planet(String nam, Market market) {
        name = nam;
        thisMarket = market;
    }
    public String getName() {
        return name;
    }
    public Market getMarket() {
        return thisMarket;
    }
    @Override
    public boolean equals(Object other) {
        Planet oth = (Planet) (other);
        return oth.getName().equals(name);
    }
    public String toString() {
        return name;
    }
}
