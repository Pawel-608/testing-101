package com.rainer.pawel.intro._2_.__1__;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayList_Bad_Test {
    /*
        Dobry test powinien:
        1. Byc powtarzalny
        2. Nie polegac na innych testach
        3. Skupiac się na testowaniu jedej funkcjonalnosci
     */


    // Błąd (2) tworzymy statyczne pole w którym przechowujemy instancję klasy, którą testujemy
    // przez to dane z każdego testu są widoczne w innych
    private static final ArrayList<Integer> arrayList = new ArrayList<>();

    private static final Integer a = 8;


    // Test testuje dużo funkcjonalnosci na raz (3)
    @Test
    void shouldAddElementAndCheckIfContainsAndClearAndThrowIndexOutOfBoundsExceptionIfNoElementAtIndex_BAD() {
        arrayList.add(a);

        assertTrue(arrayList.contains(a));
        assertEquals(a, arrayList.get(0));

        arrayList.clear();

        assertFalse(arrayList.contains(a));
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(0));

        arrayList.add(a);
    }

    @RepeatedTest(50)
    void shouldCheckIfContains_BAD() {
        // Test polega na poprzednim tescie (2) - zakłada, że a jest już w srodku listy
        assertTrue(arrayList.contains(a));

        // Test nie jest powtarzalny (1) czasem może failowac mimo, że funkcjonalnosc działa
        assertFalse(arrayList.contains(getRandomInteger()));
    }


    private int getRandomInteger() {
        int min = 0;
        int max = 10;

        return (int) ((Math.random() * (max - min)) + min);
    }
}
