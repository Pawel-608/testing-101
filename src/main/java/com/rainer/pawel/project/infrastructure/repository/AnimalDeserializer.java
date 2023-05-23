package com.rainer.pawel.project.infrastructure.repository;

import com.rainer.pawel.project.domain.Animal;
import com.rainer.pawel.project.domain.AnimalType;
import com.rainer.pawel.project.domain.Name;
import com.rainer.pawel.project.domain.Price;
import com.rainer.pawel.project.domain.utils.AnimalCatalogException;

import java.util.UUID;

import static com.rainer.pawel.project.domain.utils.EnsureUtils.ensureThat;
import static java.lang.Integer.parseInt;

public class AnimalDeserializer {

    public Animal deserialize(String animal) {
        if (animal == null || animal.isBlank()) {
            return null;
        }

        String[] animalSplit = animal.split(",");

        ensureThat(animalSplit.length == 4, "Invalid animal format");

        try {
            return new Animal(
                    UUID.fromString(animalSplit[0]),
                    Name.of(animalSplit[1]),
                    AnimalType.getAnimalType(animalSplit[2]),
                    Price.of(parseInt(animalSplit[3]))
            );
        } catch (Exception e) {
            throw new AnimalCatalogException("Error during animal serialization", e);
        }
    }
}
