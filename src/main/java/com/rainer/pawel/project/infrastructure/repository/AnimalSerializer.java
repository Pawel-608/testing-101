package com.rainer.pawel.project.infrastructure.repository;

import com.rainer.pawel.project.domain.Animal;

public class AnimalSerializer {

    public String serialize(Animal animal) {
        return String.format("%s,%s,%s,%s",
                animal.getId(),
                animal.getName(),
                animal.getType(),
                animal.getPrice().asInt());
    }
}
