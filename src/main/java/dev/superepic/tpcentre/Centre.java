package dev.superepic.tpcentre;

public final class Centre {
    private Centre() {
    }

    public static double of(double coord) {
        return Math.floor(coord) + 0.5;
    }
}
