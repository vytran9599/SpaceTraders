package edu.gatech.cs2340.spacetraders.model;

public enum Resources {
    NOSPECIALRESOURCES (0),
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
    public int getValue() {
        return value;
    }
    public static Resources getResourcesByNumber(int a) {
        for (Resources re : values()) {
            if (re.getValue() == a) {
                return re;
            }
        }
        return NOSPECIALRESOURCES;
    }
}
