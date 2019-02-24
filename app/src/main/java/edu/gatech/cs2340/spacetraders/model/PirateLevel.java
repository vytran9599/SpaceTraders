package edu.gatech.cs2340.spacetraders.model;

public enum PirateLevel {
    FEW (0),
    SEVERAL(1),
    MANY (2),
    ABUNDANT (3);

    private final int value;

    PirateLevel(int v) {this.value = v;}
    public int getValue() {return value;}
    public static PirateLevel getLevelByNumber(int a) {
        for (PirateLevel level: values()) {
            if (level.getValue() == a) {
                return level;
            }
        }
        return FEW;
    }
}
