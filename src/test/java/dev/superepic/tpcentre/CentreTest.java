package dev.superepic.tpcentre;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CentreTest {
    @ParameterizedTest
    @CsvSource({"10.3, 10.5", "5.0, 5.5", "-0.2, -0.5", "-10.7, -10.5"})
    void centresOnContainingBlock(double coordinate, double expected) {
        assertEquals(expected, Centre.of(coordinate), 1e-9);
    }
}
