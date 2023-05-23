package com.rainer.pawel.intro._2_.__2__;

import com.rainer.pawel.intro._2_.__1__.ArrayListTest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayList_Improved_Test {

    /**
     * @see ArrayListTest
     */

    /*
        W poprzedniej klasie testowej w każdym tescie pojawiała się linia:

        ArrayList<Integer> arrayList = new ArrayList<>();

        miało to upewnic nas, że żaden z testów nie używa array listy,
        której używał poprzedni (żaden test nie powinien polegac na innym)


        Jednak JUnit dla każdego kolejnego testu tworzy nową instancję klasy testowej
        Można to sobie wyobrazic, że JUnit nasz kod testuje tak:

        new ArrayListTest.shouldAddElementToList()
        new ArrayListTest.shouldRetrieveElementByIndex()
        new ArrayListTest.shouldThrowIndexOutOfBoundsExceptionIfNoElementAtIndex()

        Więc pola klasy (nie statyczne), będą ustawiane od nowa dla każdego testu,
        co pozwala nam na uproszczenie ich prszez wyciągnięcie powtarzającego się
        fragmentu kodu:
     */

    private final ArrayList<Integer> arrayList = new ArrayList<>();

    @Test
    void shouldAddElementToList() {
        // given
        Integer a = 8;

        // when
        arrayList.add(a);

        // then
        assertEquals(a, arrayList.get(0));
    }

    @Test
    void shouldRetrieveElementByIndex() {
        // given
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
        // expect
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(0));
    }
}
