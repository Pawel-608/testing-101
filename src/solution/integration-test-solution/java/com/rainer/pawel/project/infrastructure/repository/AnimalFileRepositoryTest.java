package com.rainer.pawel.project.infrastructure.repository;

import com.rainer.pawel.project.domain.Animal;
import com.rainer.pawel.project.domain.AnimalType;
import com.rainer.pawel.project.domain.Name;
import com.rainer.pawel.project.domain.Price;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;


import static com.rainer.pawel.project.domain.AnimalType.BIRD;
import static com.rainer.pawel.project.domain.AnimalType.MAMMAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnimalFileRepositoryTest {

    Path basePath = createTempDir();

    AnimalDeserializer animalDeserializer = new AnimalDeserializer();

    AnimalSerializer animalSerializer = new AnimalSerializer();

    AnimalFileRepository animalFileRepository = new AnimalFileRepository(
            basePath,
            animalDeserializer,
            animalSerializer
    );

    @Test
    void shouldSaveAnimal() {
        // given
        UUID testAnimalId = UUID.randomUUID();

        Animal animal = createAnimal(
                testAnimalId,
                "Bob",
                MAMMAL,
                10
        );

        // when
        animalFileRepository.save(animal);

        // then
        Animal actualAnimal = animalFileRepository.findById(testAnimalId);

        assertEquals(animal.getId(), actualAnimal.getId());
        assertEquals(animal.getName(), actualAnimal.getName());
        assertEquals(animal.getType(), actualAnimal.getType());
        assertEquals(animal.getPrice(), actualAnimal.getPrice());
    }

    @Test
    void shouldDeleteAnimal() {
        // given
        UUID testId1 = UUID.randomUUID();
        UUID testId2 = UUID.randomUUID();

        Animal animal1 = createAnimal(
                testId1,
                "Bob",
                MAMMAL,
                10
        );

        Animal animal2 = createAnimal(
                testId2,
                "Joe",
                BIRD,
                20
        );

        // when
        animalFileRepository.save(animal1);
        animalFileRepository.save(animal2);

        animalFileRepository.delete(testId2);

        // then
        List<Animal> foundAnimals = animalFileRepository.findAll();

        assertEquals(1, foundAnimals.size());
        assertTrue(foundAnimals.contains(animal1));
    }

    @Test
    void shouldFindAllAnimals() {
        // given
        UUID testId1 = UUID.randomUUID();
        UUID testId2 = UUID.randomUUID();

        Animal animal1 = createAnimal(
                testId1,
                "Bob",
                MAMMAL,
                10
        );

        Animal animal2 = createAnimal(
                testId2,
                "Joe",
                BIRD,
                20
        );

        // when
        animalFileRepository.save(animal1);
        animalFileRepository.save(animal2);

        // then
        List<Animal> foundAnimals = animalFileRepository.findAll();

        assertEquals(2, foundAnimals.size());
        assertTrue(foundAnimals.contains(animal1));
        assertTrue(foundAnimals.contains(animal2));
    }

    Path createTempDir() {
        try {
            return Files.createTempDirectory("animal-repository");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    Animal createAnimal(UUID id, String name, AnimalType type, int price) {
        return new Animal(
                id,
                Name.of(name),
                type,
                Price.of(price)
        );
    }
}
