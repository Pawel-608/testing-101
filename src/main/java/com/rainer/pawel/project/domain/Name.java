package com.rainer.pawel.project.domain;

import static com.rainer.pawel.project.domain.utils.EnsureUtils.ensureThat;

public class Name {

    private static final String nameRegexp = "^[a-zA-Z]+$";

    private final String name;

    public Name(String name) {
        ensureThat(name.matches(nameRegexp), "Name must be only letters");
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name1 = (Name) o;

        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
