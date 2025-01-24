package uk.ac.nott.cs.frogger.views;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {

    @Test
    void getLeft() {

        Log log = new Log(0);
        assertFalse(log.getLeft());
    }
}