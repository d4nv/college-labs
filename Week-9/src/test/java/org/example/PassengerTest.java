package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    void validPassengerShouldBeCreated() {
        Passenger p = new Passenger("Mr", "John", "Smith");
        assertEquals("Mr", p.getTitle());
        assertEquals("John", p.getFirstName());
        assertEquals("Smith", p.getLastName());
    }

    @Test
    void invalidTitleShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("Dr", "John", "Smith");
        });
    }

    @Test
    void shortFirstNameShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("Mr", "Jo", "Smith");
        });
    }

    @Test
    void shortLastNameShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Passenger("Ms", "Jane", "Li");
        });
    }
}
