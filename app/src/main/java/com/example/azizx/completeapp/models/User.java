package com.example.azizx.completeapp.models;

import java.util.Objects;

public class User {

    public String name;
    public String password;


    public User() {

    }


    // Needed for authUser()
    // users.contains() require equals() for comparison.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
