package com.rainer.pawel.project.application;

import com.rainer.pawel.project.domain.Animal;
import com.rainer.pawel.project.domain.AnimalType;
import com.rainer.pawel.project.domain.Price;
import com.rainer.pawel.project.domain.PriceRange;
import org.junit.jupiter.api.Test;
import java.util.List;


import static com.rainer.pawel.project.domain.AnimalType.BIRD;
import static com.rainer.pawel.project.domain.AnimalType.FISH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AnimalServiceTest {

    AnimalRepository animalRepository = mock(AnimalRepository.class);

    AnimalService animalService = new AnimalService(animalRepository);

    @Test
    void shouldFindAllAnimalsInPriceRange() {
        // given
        PriceRange testPriceRange = new PriceRange(Price.of(7), Price.of(25));

        Animal animal1 = getAnimal(5);
        Animal animal2 = getAnimal(10);
        Animal animal3 = getAnimal(30);

        when(animalRepository.findAll()).thenReturn(List.of(animal1, animal2, animal3));

        // when
        List<Animal> actualAnimals = animalService.findAllInPriceRange(testPriceRange);

        // then
        assertEquals(actualAnimals.size(), 1);
        assertTrue(actualAnimals.contains(animal2));
    }

    @Test
    void shouldFindAnimalsWithType() {
        // given
        Animal animal1 = getAnimal(BIRD);
        Animal animal2 = getAnimal(BIRD);
        Animal animal3 = getAnimal(FISH);

        when(animalRepository.findAll()).thenReturn(List.of(animal1, animal2, animal3));

        // when
        List<Animal> actualAnimals = animalService.findAllWithType(BIRD);

        // then
        assertEquals(actualAnimals.size(), 2);
        assertTrue(actualAnimals.contains(animal1));
        assertTrue(actualAnimals.contains(animal2));
    }

    // Możesz też stworzyc instancję Animal z
    // jakąs domyslną wartoscią, ale w tym wypadku
    // prosciej jest po prostu je zamockowac
    Animal getAnimal(int price) {
        Animal animal = mock(Animal.class);

        when(animal.getPrice()).thenReturn(Price.of(price));

        return animal;
    }

    Animal getAnimal(AnimalType animalType) {
        Animal animal = mock(Animal.class);

        when(animal.getType()).thenReturn(animalType);

        return animal;
    }
}