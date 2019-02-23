package edu.gatech.cs2340.spacetraders.model;


public class Planet {
    private String name;

    public Planet(String nam) {
        name = nam;
    }
    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object other) {
        Planet oth = (Planet) (other);
        return oth.getName().equals(name);
    }
}
