package com.rainer.pawel.project.domain;

import java.util.UUID;

import static com.rainer.pawel.project.domain.utils.EnsureUtils.ensureThat;
import static java.util.Objects.nonNull;

public final class Animal {

    private final UUID id;

    private final Name name;

    private final AnimalType type;

    private final Price price;

    public Animal(UUID id, Name name, AnimalType type, Price price) {
        ensureThat(nonNull(id), "Id must be present");

        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name=" + name +
                ", type=" + type +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return id.equals(animal.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
