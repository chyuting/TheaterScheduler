package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
    @Test
    void NoDiscount() {
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        assertEquals("Turning Red", turningRed.getTitle());
        assertEquals(11, turningRed.getTicketPrice());
        assertEquals(0, turningRed.getSpecialCode());
        assertEquals(Duration.ofMinutes(85), turningRed.getRunningTime());
    }
}
