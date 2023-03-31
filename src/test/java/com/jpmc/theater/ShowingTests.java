package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShowingTests {

    @Test
    void NoDiscount() {
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Showing showing = new Showing(turningRed, 3, LocalDateTime.of(LocalDate.of(2023, 4, 2), LocalTime.of(17, 0)));
        System.out.println("No discount: " + showing.toString());
        assertEquals(11, showing.calculateTicketPrice());
    }

    @Test
    void specialMovieWith20PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 0)));
        System.out.println("20% off discount: " + showing.toString());
        assertEquals(10, showing.calculateTicketPrice());
    }

    @Test
    void happyhour25PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 0)));
        System.out.println("25% off discount: " + showing.toString());
        assertEquals(9.375, showing.calculateTicketPrice());
    }

    @Test
    void firstSequence3offDiscount() {
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Showing showing = new Showing(turningRed, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(10, 0)));
        System.out.println("$3 off discount: " + showing.toString());
        assertEquals(8, showing.calculateTicketPrice());
    }

    @Test
    void secondSequence2offDiscount() {
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Showing showing = new Showing(turningRed, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0)));
        System.out.println("$2 off discount: " + showing.toString());
        assertEquals(9, showing.calculateTicketPrice());
    }

    @Test
    void seventhDayDiscount() {
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Showing showing = new Showing(turningRed, 3, LocalDateTime.of(LocalDate.of(2023, 4, 7), LocalTime.of(17, 0)));
        System.out.println("$1 off discount: " + showing.toString());
        assertEquals(10, showing.calculateTicketPrice());
    }
}
