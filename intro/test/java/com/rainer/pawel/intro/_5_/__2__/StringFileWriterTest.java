package com.rainer.pawel.intro._5_.__2__;

import com.rainer.pawel.intro._5_.StringFileWriter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringFileWriterTest {

    /*
        Tutaj testy klasy StringFileWriter - sprawdzamy w nich
         - Czy zapisywanie do nieistniejącego pliku działa
         - Czy zapisywanie do istniejącego pliku działa
         - Czy poprzedni content pliku zostanie nadpisany

         Są one zdecydowanie bardziej skomplikowane od zwykłych unit testów (bardziej przypominają
         testy integracyjne - o nich za chwilę), bo wymagają stworzenia tymczasowych plików,
         ich zapisu, odczytu i usuwania po każdym tescie
     */

    StringFileWriter stringFileWriter = new StringFileWriter();

    String TEST_CONTENT = """
            test content 123
            a
            b
            """;

    @Test
    void shouldWriteToFile() throws IOException {
        // given
        String tempFilePath = getTempFilePath();

        // when
        stringFileWriter.write(tempFilePath, TEST_CONTENT);

        // then
        String actualContent = readFile(tempFilePath);
        assertEquals(TEST_CONTENT, actualContent);
    }

    @Test
    void shouldWriteToExistingFile() throws IOException {
        // given
        String tempFilePath = createTempFile().getAbsolutePath();

        // when
        stringFileWriter.write(tempFilePath, TEST_CONTENT);

        // then
        String actualContent = readFile(tempFilePath);
        assertEquals(TEST_CONTENT, actualContent);
    }

    @Test
    void shouldOverwriteExistingFileContent() throws IOException {
        // given
        String tempFilePath = createTempFileWithContent("Some initial content").getAbsolutePath();

        // when
        stringFileWriter.write(tempFilePath, TEST_CONTENT);

        // then
        String actualContent = readFile(tempFilePath);
        assertEquals(TEST_CONTENT, actualContent);
    }

    String getTempFilePath() throws IOException {
        File f = createTempFile();
        f.delete();

        return f.getAbsolutePath();
    }

    File createTempFileWithContent(String content) throws IOException {
        File f = createTempFile();

        writeToFile(f.getAbsolutePath(), content);
        return f;
    }

    File createTempFile() throws IOException {
        File f = File.createTempFile("string-file-writer-test", ".txt");
        f.deleteOnExit();

        return f;
    }

    public String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    void writeToFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }
}