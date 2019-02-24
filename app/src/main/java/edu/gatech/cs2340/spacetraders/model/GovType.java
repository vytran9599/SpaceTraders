package edu.gatech.cs2340.spacetraders.model;

public enum GovType {
    DEMOCRACY (0),
    DICTATORSHIP (1),
    MILITARY (2),
    MONARCHY (3),
    SOCIALIST (5);

    private final int value;

    GovType(int v) {this.value = v;}
    public int getValue() {return value;}
    public static GovType getTypeByNumber(int a) {
        for (GovType level: values()) {
            if (level.getValue() == a) {
                return level;
            }
        }
        return DEMOCRACY;
    }
}
