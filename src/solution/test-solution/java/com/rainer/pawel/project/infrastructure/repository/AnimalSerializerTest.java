package com.rainer.pawel.project.infrastructure.repository;

import com.rainer.pawel.project.domain.Animal;
import com.rainer.pawel.project.domain.Name;
import com.rainer.pawel.project.domain.Price;
import org.junit.jupiter.api.Test;

import java.util.UUID;


import static com.rainer.pawel.project.domain.AnimalType.BIRD;
import static org.junit.jupiter.api.Assertions.*;

class AnimalSerializerTest {

    AnimalSerializer animalSerializer = new AnimalSerializer();

    @Test
    void shouldSerializeAnimal() {
        // given
        UUID animalId = UUID.randomUUID();

        String expectedSerializedAnimal = String.format("%s,Bob,BIRD,10", animalId);
        Animal animal = new Animal(animalId, Name.of("Bob"), BIRD, Price.of(10));

        // when
        String actualSerializedAnimal = animalSerializer.serialize(animal);

        // then
        assertEquals(expectedSerializedAnimal, actualSerializedAnimal);
    }
}