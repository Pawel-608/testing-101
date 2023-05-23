package com.rainer.pawel.intro._2_.__1__;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListTest {
    /*
        Najprostszym typem testów są testy jednostkowe (unit testy), to testy które:
        - Testują najmniejszy możliwy zakres kodu (w javie jest to zwykle pojedyńcza klasa)
        - Pozwalają w łatwy sposób sprawdzic czy nasz kod spełnia założenia
        - Są proste do napisania
        - Wykonują się szybko

        Ze względu na to, że ich pisanie i wykonywanie jest mało kosztowne należy pokryc nimi jak największą częsc funkcjonalnosci,
        żeby zminimalizowac potrzebę pisania innych testów
    */

    /*
        Dobry test powinien:
        1. Byc powtarzalny
        2. Nie polegac na innych testach
        3. Skupiac się na testowaniu jedej funkcjonalnosci
     */

    /**
     * Przykłady złych testów:
     * {@link ArrayList_Bad_Test ArrayList_Bad_Test}
     */

    /*
        Poniżej przykładowe testy klasy ArrayList
     */
    @Test
    void shouldAddElementToList() {
        // given
        ArrayList<Integer> arrayList = new ArrayList<>();

        Integer a = 8;

        // when
        arrayList.add(a);

        // then
        assertEquals(a, arrayList.get(0));
    }

    @Test
    void shouldRetrieveElementByIndex() {
        // given
        ArrayList<Integer> arrayList = new ArrayList<>();

        Integer a = 8;
        Integer b = 30;

        // when
        arrayList.add(a);
        arrayList.add(b);

        // then
        assertEquals(a, arrayList.get(0));
        assertEquals(b, arrayList.get(1));
    }

    // Możemy również sprawdzac, czy zostają rzucone wyjątki:

    @Test
    void shouldThrowIndexOutOfBoundsExceptionIfNoElementAtIndex() {
        // given
        ArrayList<Integer> arrayList = new ArrayList<>();

        // when

        // then
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(0));
    }
}
