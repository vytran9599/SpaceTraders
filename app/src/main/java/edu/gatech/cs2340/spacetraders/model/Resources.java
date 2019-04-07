package edu.gatech.cs2340.spacetraders.model;

/**
 * resources class
 */
public enum Resources {
    NOSPECRESOURCES (0),
    MINERALRICH (1),
    MINERALPOOR (2),
    DESERT (3),
    LOTSOFWATER(4),
    RICHSOIL (5),
    POORSOIL (6),
    RICHFAUNA (7),
    LIFELESS (8),
    WEIRDMUSHROOMS (9),
    LOTSOFHERBS (10),
    ARTISTIC (11),
    WARLIKE (12);

    private final int value;
    Resources(final int newValue) {
        value = newValue;
    }

    /**
     * getters for value
     * @return integer
     */
    public int getValue() {
        return value;
    }

    /**
     * getters for resources
     * @param a integer
     * @return resources
     */
    public static Resources getResourcesByNumber(int a) {
        for (Resources re : values()) {
            if (re.getValue() == a) {
                return re;
            }
        }
        return NOSPECRESOURCES;
    }
}
