package edu.gatech.cs2340.spacetraders.model;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Solar System class
 */
public class SolarSystem {
    private final Coordinate coord;
    private final String name;
    private final TechLevel tech;
    private final Resources resource;
    private final GovType gov;
    private final PirateLevel pirate;
    private final PoliceLevel police;
    private final Condition condition;
    private final HashSet<Planet> planets;

    /**
     * solar system constructor
     * @param coor coordinate
     * @param nam string
     * @param tec techlevel
     * @param recourc resources
     * @param g government type
     * @param pi pirate level
     * @param po police level
     * @param cond condition
     * @param planet planet
     */
    public SolarSystem(Coordinate coor, String nam, TechLevel tec, Resources recourc, GovType g,
                       PirateLevel pi, PoliceLevel po, Condition cond, HashSet<Planet> planet) {
        coord = coor;
        name = nam;
        tech = tec;
        resource = recourc;
        gov = g;
        pirate = pi;
        police = po;
        planets = planet;
        condition = cond;
    }

    @Override
    public boolean equals(Object other) {
        SolarSystem newP = (SolarSystem) other;
        return newP.getName().equals(name) || newP.getCoordinate().equals(coord);
    }

    /**
     * get random planets
     * @return planet
     */
    public Planet getRandomPlanet() {
        int i = 0;
        int rand = (int) (Math.random() * 3);
        //Planet ans = null;
        Planet ans = null;
        for (Planet p:planets) {
            ans = p;
            if (i == rand) {
                return p;
            }
            i++;
        }
        return ans;
    }

    /**
     * get coordinate
     * @return coordinate
     */
    public Coordinate getCoordinate() {
        return coord;
    }

    /**
     * get name
     * @return string
     */
    public String getName() {
        return name;
    }

    /**
     * get tech level
     * @return tech level
     */
    public TechLevel getTechLevel() {
        return tech;
    }

    /**
     * get resources
     * @return resources
     */
    public Resources getResource() {
        return resource;
    }

    /**
     * get government level
     * @return government level
     */
    public GovType getGovLevel() {return gov;}

    /**
     * get pirate level
     * @return pirate level
     */
    public PirateLevel getPirateLevel() {return pirate;}
    /**
     * get police level
     * @return police level
     */
    public PoliceLevel getPoliceLevel() {return police;}
    /**
     * get planet
     * @return planet
     */
    public HashSet<Planet> getPlanets() {
        return planets;
    }

    /**
     * has planet
     * @param name string
     * @return boolean
     */
    public boolean hasPlanet(String name) {
        for(Planet a:planets) {
            if (a.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * get planet
     * @param name string
     * @return planet
     */
    public Planet getPlanetByName(String name) {
        for(Planet p:planets) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        throw new java.util.NoSuchElementException("No planet with name " + name +
                " exist in the solar system " + name + ".");
    }

    /**
     * get condition
     * @return condition
     */
    public Condition getCondition() {
        return condition;
    }
    public String toString() {
        String p = "";
        for(Planet a:planets) {
            p = p + a + " ";
        }
        return "Name of Solar System: " + name + "\n" + coord +
                "\nTechLevel: " + tech + "\nResources: " + resource +
                "\nGovernment Type: " + gov + "\nPirate Level: " +
                pirate + "\nPolice Level: " + police + "\nCondition: " + condition
                + "\nPlanets: " + p + "\n";
    }


}
