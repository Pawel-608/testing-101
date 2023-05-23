package com.rainer.pawel.intro._5_.__1__;

import com.rainer.pawel.intro._5_.SplittingRepositoryException;
import com.rainer.pawel.intro._5_.StringFileWriter;
import com.rainer.pawel.intro._5_.StringSplittingRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StringSplittingRepositoryTest {

    /*
            Poprzednie testy były proste - klasy, które testowalismy nie miały żadnych odniesień do
            innych klas - cała ich funkcjonalnosc opierała się o nie same. W tym wypadku jest inaczej:
            klasa "StringSplittingRepository" używa "StringFileWriter" (zobacz implementację).

            Pisząc test jednostkowy chcemy przetestowac tylko klasę "StringSplittingRepository",
            żeby to zrobic należy "zamockowac" (stworzyc fejkowy obiekt, którym możemy sterowac w tescie)
            klasę "StringFileWriter" i "wstrzyknąc" ją do klasy, którą chcemy przetestowac.

            Używając biblioteki Mockito, robimy to w ten sposób:
    */

    StringFileWriter stringFileWriter = Mockito.mock(StringFileWriter.class);

    StringSplittingRepository stringSplittingRepository = new StringSplittingRepository(stringFileWriter);

    /*
            Teraz możemy prosto stworzyc testy:
    */

    @Test
    void shouldTryToSaveSplitString() {
        // given
        String testFilePath = "/test/path";

        // udajemy klasę "stringFileWriter" - po wywołaniu metody stringFileWriter.write()
        // z argumentami:
        // "filePath"  - "testFilePath"
        // "content"   -  dowolny
        // zostanie zwrócona wartosc 'true'
        when(stringFileWriter.write(eq(testFilePath), any())).thenReturn(true);

        String stringToSave = "abc";
        String expectedContent = """
                a
                b
                c
                """;

        // when
        String actual = stringSplittingRepository.save(testFilePath, stringToSave);

        // then
        assertEquals(expectedContent, actual);

        // dodatkowo sprawdzamy, jakie były interakcje z naszym zamockowanym obiektem:
        verify(stringFileWriter, times(1)).write(testFilePath, expectedContent);
    }

    @Test
    void shouldThrowIfErrorWhileSavingToFile() {
        // given
        String testFilePath = "/test/path";
        String stringToSave = "abc";

        when(stringFileWriter.write(any(), any())).thenReturn(false);

        // expect
        assertThrows(SplittingRepositoryException.class, () -> stringSplittingRepository.save(testFilePath, stringToSave));
    }

}