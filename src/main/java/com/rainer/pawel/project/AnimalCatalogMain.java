package com.rainer.pawel.project;

import com.rainer.pawel.project.adapters.inbound.ConsoleLineInterface;
import com.rainer.pawel.project.application.AnimalService;
import com.rainer.pawel.project.infrastructure.repository.AnimalDeserializer;
import com.rainer.pawel.project.infrastructure.repository.AnimalFileRepository;
import com.rainer.pawel.project.infrastructure.repository.AnimalSerializer;
import java.nio.file.Path;
import java.util.UUID;
import java.util.function.Supplier;

public class AnimalCatalogMain {

    public static void main(String[] args) {
        AnimalFileRepository animalRepository = new AnimalFileRepository(
                Path.of(System.getProperty("user.dir"), "animals"),
                new AnimalDeserializer(),
                new AnimalSerializer()
        );

        AnimalService animalService = new AnimalService(animalRepository);

        Supplier<UUID> animalIdSupplier = () -> UUID.randomUUID();

        new ConsoleLineInterface(animalRepository, animalService, animalIdSupplier).run();
    }
}
