package edu.gatech.cs2340.spacetraders.model;

/**
 * Enum keeps track of conditions
 */
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

    /**
     * Get value
     * @return integer
     */
    public int getValue() {
        return value;
    }

    /**
     * Get condition
     * @param a integer value
     * @return Condition
     */
    public static Condition getConditionByNumber(int a) {
        for (Condition re : values()) {
            if (re.getValue() == a) {
                return re;
            }
        }
        return NORMAL;
    }
}
