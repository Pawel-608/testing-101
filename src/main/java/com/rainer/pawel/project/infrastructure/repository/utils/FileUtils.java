package com.rainer.pawel.project.infrastructure.repository.utils;

import com.rainer.pawel.project.domain.utils.AnimalCatalogException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public final class FileUtils {

    public static String read(Path filePath) {
        try {
            return new String(Files.readAllBytes(filePath));
        } catch (NoSuchFileException e) {
            return null;
        } catch (IOException e) {
            throw new AnimalCatalogException(e);
        }
    }

    public static void write(Path filePath, String s) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            writer.write(s);
        } catch (IOException e) {
            throw new AnimalCatalogException(e);
        }
    }

    public static void delete(Path filePath) {
        try {
            Files.delete(filePath);
        } catch (NoSuchFileException e) {
            throw new AnimalCatalogException(String.format("Animal %s do not exist", filePath.getFileName()));
        } catch (IOException e) {
            throw new AnimalCatalogException(String.format("Error occurred while deleting animal %s", filePath.getFileName()), e);
        }
    }

    public static List<Path> findFilesInDirectory(Path directory) {
        File[] files = directory.toFile().listFiles();
        if (files == null) {
            return Collections.emptyList();
        }

        return Stream.of(files)
                .filter(file -> !file.isDirectory())
                .map(File::toPath)
                .toList();
    }

    private FileUtils() {
    }
}
