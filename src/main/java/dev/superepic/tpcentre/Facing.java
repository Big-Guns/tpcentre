package dev.superepic.tpcentre;

public enum Facing {
    SOUTH(0f, "South"),
    WEST(90f, "West"),
    NORTH(180f, "North"),
    EAST(-90f, "East");

    private final float yaw;
    private final String displayName;

    Facing(float yaw, String displayName) {
        this.yaw = yaw;
        this.displayName = displayName;
    }

    public float yaw() {
        return yaw;
    }

    public String displayName() {
        return displayName;
    }

    public static Facing nearest(float yaw) {
        double normalised = yaw % 360.0;
        if (normalised < 0) {
            normalised += 360.0;
        }
        int index = (int) Math.floor((normalised + 45.0) / 90.0) % 4;
        return values()[index];
    }
}
