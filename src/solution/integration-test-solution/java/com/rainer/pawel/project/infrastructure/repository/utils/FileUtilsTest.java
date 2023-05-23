package com.rainer.pawel.project.infrastructure.repository.utils;

import com.rainer.pawel.project.domain.utils.AnimalCatalogException;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileUtilsTest {

    @Test
    void shouldReadFile() {
        // given
        String expectedText = "some text";
        Path testFile = createTempFile();

        FileUtils.write(testFile, expectedText);

        // when
        String actualText = FileUtils.read(testFile);

        // then
        assertEquals(expectedText, actualText);
    }

    @Test
    void shouldReturnNullIfFileDoNotExist() {
        // given
        Path fileThatDoNotExists = Path.of("a", "b", "c");

        // when
        String actualText = FileUtils.read(fileThatDoNotExists);

        // then
        assertNull(actualText);
    }

    @Test
    void shouldDeleteFile() {
        // given
        Path testFile = createTempFile();

        // when
        FileUtils.delete(testFile);

        // then
        assertFalse(testFile.toFile().exists());
    }

    @Test
    void shouldThrowIfTryingToDeleteNonExistingFile() {
        // given
        Path testFile = Path.of("a", "b", "c");

        // when
        assertThrows(AnimalCatalogException.class,
                () -> FileUtils.delete(testFile));
    }

    @Test
    void shouldFindFilesInDirectory() {
        // given
        Path testDir = createTempDir();

        Path testFile1 = createTempFile(testDir);
        Path testFile2 = createTempFile(testDir);

        // when
        List<Path> foundFiles = FileUtils.findFilesInDirectory(testDir);

        // then
        assertEquals(2, foundFiles.size());
        assertTrue(foundFiles.contains(testFile1));
        assertTrue(foundFiles.contains(testFile2));
    }

    @Test
    void shouldReturnEmptyListIfDirectoryDoNotExists() {
        // given
        Path testDir = Path.of("a", "b", "c");

        // when
        List<Path> foundFiles = FileUtils.findFilesInDirectory(testDir);

        // then
        assertEquals(0, foundFiles.size());
    }

    Path createTempFile() {
        try {
            return Files.createTempFile("test-file-utils", ".txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    Path createTempFile(Path directory) {
        try {
            return Files.createTempFile(directory, "test-file-utils", ".txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    Path createTempDir() {
        try {
            return Files.createTempDirectory("animal-repository");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}