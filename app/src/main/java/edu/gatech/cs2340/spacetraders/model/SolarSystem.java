package edu.gatech.cs2340.spacetraders.model;

import java.util.ArrayList;
import java.util.HashSet;

public class SolarSystem {
    private Coordinate coord;
    private String name;
    private TechLevel tech;
    private Resources resource;
    private HashSet<Planet> planets;

    public SolarSystem(Coordinate coor, String nam, TechLevel tec, Resources recourc, HashSet<Planet> planet) {
        coord = coor;
        name = nam;
        tech = tec;
        resource = recourc;
        planets = planet;
    }

    @Override
    public boolean equals(Object other) {
        SolarSystem newP = (SolarSystem) other;
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
    public Resources getResource() {
        return resource;
    }
    public HashSet<Planet> getPlanets() {
        return planets;
    }


}
