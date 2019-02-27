package edu.gatech.cs2340.spacetraders.model;

public enum Condition {
    DROUGHT (0),
    COLD (1),
    CROPFAIL (2),
    WAR (3),
    BOREDOM (4),
    PLAGUE (5),
    LACKOOFWORKERS (6),
    NORMAL (7);

    private final int value;
    Condition(final int newValue) {
        value = newValue;
    }
    public int getValue() {
        return value;
    }
    public static Condition getConditionByNumber(int a) {
        for (Condition re : values()) {
            if (re.getValue() == a) {
                return re;
            }
        }
        return NORMAL;
    }
}
