package com.rainer.pawel.project.infrastructure.repository;

import com.rainer.pawel.project.application.AnimalRepository;
import com.rainer.pawel.project.domain.Animal;
import com.rainer.pawel.project.infrastructure.repository.utils.FileUtils;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

public class AnimalFileRepository implements AnimalRepository {

    private final Path repositoryBasePath;

    private final AnimalDeserializer animalDeserializer;

    private final AnimalSerializer animalSerializer;

    public AnimalFileRepository(
            Path repositoryBasePath,
            AnimalDeserializer animalDeserializer,
            AnimalSerializer animalSerializer
    ) {
        repositoryBasePath.toFile().mkdirs();

        this.repositoryBasePath = repositoryBasePath;
        this.animalDeserializer = animalDeserializer;
        this.animalSerializer = animalSerializer;
    }

    @Override
    public void save(Animal animal) {
        String deserializedAnimal = animalSerializer.serialize(animal);

        FileUtils.write(getPath(animal.getId()), deserializedAnimal);
    }

    @Override
    public void delete(UUID id) {
        FileUtils.delete(getPath(id));
    }

    @Override
    public Animal findById(UUID id) {
        return getAnimal(getPath(id));
    }

    @Override
    public List<Animal> findAll() {
        return FileUtils.findFilesInDirectory(repositoryBasePath)
                .stream()
                .map(this::getAnimal)
                .toList();
    }

    private Animal getAnimal(Path filePath) {
        String animalString = FileUtils.read(filePath);
        return animalDeserializer.deserialize(animalString);
    }

    private Path getPath(UUID id) {
        return repositoryBasePath.resolve(id.toString());
    }
}
