package com.rainer.pawel.project.domain;

public enum AnimalType {
    MAMMAL,
    FISH,
    BIRD,
    REPTILE;

    public static AnimalType getAnimalType(String type) {
        return AnimalType.valueOf(type.toUpperCase());
    }

}
