package com.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testApplicationLaunches() {
        // Basic test to verify the module loads
        assertNotNull(new Main());
    }
}
