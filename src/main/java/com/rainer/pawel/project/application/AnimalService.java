package com.rainer.pawel.project.application;

import com.rainer.pawel.project.domain.Animal;
import com.rainer.pawel.project.domain.AnimalType;
import com.rainer.pawel.project.domain.PriceRange;

import java.util.List;

public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> findAllInPriceRange(PriceRange priceRange) {
        return animalRepository.findAll()
                .stream()
                .filter(animal -> priceRange.contains(animal.getPrice()))
                .toList();
    }

    public List<Animal> findAllWithType(AnimalType type) {
        return animalRepository.findAll()
                .stream()
                .filter(animal -> animal.getType().equals(type))
                .toList();
    }

}
