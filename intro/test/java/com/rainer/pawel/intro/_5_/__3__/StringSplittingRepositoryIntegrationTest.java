package com.rainer.pawel.intro._5_.__3__;

import com.rainer.pawel.intro._5_.StringFileWriter;
import com.rainer.pawel.intro._5_.StringSplittingRepository;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSplittingRepositoryIntegrationTest {

    /*
            Oprócz unit testów istnieją również inne testy - testy integracyjne. Zamiast na testowaniu
            funkcjonalnosci klas, sprawdzają one jak działają one między sobą. Testy integracyjne,
            w przeciwieństwie do jednostkowych są trudne do napisania i często kosztowne w
            wykonywaniu - z tego powodu należy pisac ich tylko tyle ile wystarczy do sprawdzenia,
            czy podstawowa funkcjonalność działa - różne wariacje należy testowac testami jednostkowymi

            Poniżej przykład testu integracyjnego klasy StringSplittingRepository
    */

    StringFileWriter stringFileWriter = new StringFileWriter();

    StringSplittingRepository stringSplittingRepository = new StringSplittingRepository(stringFileWriter);

    @Test
    void shouldSaveSplitString() throws IOException {
        // given
        String testFilePath = getTempFilePath();

        String stringToSave = "abc";
        String expectedContent = """
                a
                b
                c
                """;

        // when
        stringSplittingRepository.save(testFilePath, stringToSave);

        // then
        String actualContent = readFile(testFilePath);

        assertEquals(expectedContent, actualContent);
    }

    String getTempFilePath() throws IOException {
        File f = File.createTempFile("string-file-writer-test", ".txt");
        f.delete();

        return f.getAbsolutePath();
    }

    public String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}