package com.rainer.pawel.project.application;

import com.rainer.pawel.project.domain.Animal;

import java.util.List;
import java.util.UUID;

public interface AnimalRepository {

    void save(Animal animal);

    void delete(UUID id);

    Animal findById(UUID id);

    List<Animal> findAll();
}
