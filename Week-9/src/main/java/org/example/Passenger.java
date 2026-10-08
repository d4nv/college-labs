package org.example;

import java.util.Arrays;
import java.util.List;

public class Passenger {
    private String title;
    private String firstName;
    private String lastName;

    private static final List<String> VALID_TITLES = Arrays.asList("Mr", "Mrs", "Ms");

    public Passenger(String title, String firstName, String lastName) {
        if (!VALID_TITLES.contains(title)) {
            throw new IllegalArgumentException("Invalid title: must be Mr, Mrs, or Ms");
        }
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name must be at least 3 characters");
        }
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name must be at least 3 characters");
        }

        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
