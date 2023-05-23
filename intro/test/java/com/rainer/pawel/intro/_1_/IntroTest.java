package com.rainer.pawel.intro._1_;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class IntroTest {

    /*
        Test to kawałek kodu wykonywany w izolacji od reszty
        Najprostszym przykładem jest metoda poniżej:
     */

    @Test
    void printNumber() {// <-- tam z boku powinien byc zielony guzik którym odpalisz test
        System.out.println(1 + 1);
    }

    /*
        Test ma za zadanie testowac jakąs funkcjonalnosc ;)
        Poniższy test sprawdza poprawnosc dodawania:
     */

    @Test
    void shouldProperlyAddTwoNumbers() {
        Assertions.assertEquals(2, 1 + 1);
    }

    // Jesli nasze założenia się nie sprawdzą - test failuje

    @Test
    @Disabled
    void thisTestShouldFail() {
        Assertions.assertEquals(2, 1234 + 5678);
    }

    /*
        Dobrą praktyką jest podzielenie testu na bloki:
        given, when i then
     */

    @Test
    void shouldProperlyAddTwoNumbers_Better() {
        // given (w tym bloku przygotowujemy nasz test - w tym wypadku po prostu ustawiamy oczekiwaną wartosc)
        int expected = 2;

        // when (w tym bloku przeprowadzamy akcję którą chcemy przetestowac)
        int actual = 1 + 1;

        // then (w tym bloku sprawdzamy czy założenia zostały spełnione)
        Assertions.assertEquals(expected, actual);
    }
}
