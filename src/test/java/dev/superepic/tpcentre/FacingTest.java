package dev.superepic.tpcentre;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FacingTest {
    @ParameterizedTest
    @CsvSource({
            "0, SOUTH", "90, WEST", "180, NORTH", "-180, NORTH",
            "-90, EAST", "270, EAST", "44.9, SOUTH", "45, WEST",
            "359, SOUTH", "720, SOUTH", "-450, EAST"
    })
    void snapsToNearestCardinalDirection(float yaw, Facing expected) {
        assertEquals(expected, Facing.nearest(yaw));
    }

    @ParameterizedTest
    @CsvSource({"SOUTH, South", "WEST, West", "NORTH, North", "EAST, East"})
    void suppliesDisplayName(Facing facing, String expected) {
        assertEquals(expected, facing.displayName());
    }

    @ParameterizedTest
    @CsvSource({"SOUTH, 0", "WEST, 90", "NORTH, 180", "EAST, -90"})
    void suppliesMinecraftYaw(Facing facing, float expected) {
        assertEquals(expected, facing.yaw());
    }
}
