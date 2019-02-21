package edu.gatech.cs2340.spacetraders.model;


public class Planet {
    private Coordinate coord;
    private String name;
    private TechLevel tech;

    public Planet(Coordinate coor, String nam, TechLevel tec) {
        coord = coor;
        name = nam;
        tech = tec;
    }

    @Override
    public boolean equals(Object other) {
        Planet newP = (Planet) other;
        return newP.getName().equals(name) && newP.getCoordinate().equals(coord);
    }

    public Coordinate getCoordinate() {
        return coord;
    }
    public String getName() {
        return name;
    }
    public TechLevel getTechLevel() {
        return tech;
    }


}
