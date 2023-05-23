package com.rainer.pawel.project.infrastructure.repository;

import com.rainer.pawel.project.domain.Animal;
import com.rainer.pawel.project.domain.Name;
import com.rainer.pawel.project.domain.Price;
import org.junit.jupiter.api.Test;
import java.util.UUID;


import static com.rainer.pawel.project.domain.AnimalType.BIRD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AnimalDeserializerTest {

    AnimalDeserializer animalDeserializer = new AnimalDeserializer();

    @Test
    void shouldDeserializeAnimal() {
        // given
        UUID animalId = UUID.randomUUID();

        String expectedSerializedAnimal = String.format("%s,Bob,BIRD,10", animalId);

        // when
        Animal animal = animalDeserializer.deserialize(expectedSerializedAnimal);

        // then
        assertEquals(animalId, animal.getId());
        assertEquals(Name.of("Bob"), animal.getName());
        assertEquals(BIRD, animal.getType());
        assertEquals(Price.of(10), animal.getPrice());
    }

    @Test
    void shouldDeserializeAnimalToNullIfGivenAnimalIsBlank() {
        // when
        Animal animal = animalDeserializer.deserialize("");

        // then
        assertNull(animal);
    }
}