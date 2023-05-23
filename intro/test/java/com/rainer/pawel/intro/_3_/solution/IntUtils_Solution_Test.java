package com.rainer.pawel.intro._3_.solution;

import com.rainer.pawel.intro._3_.IntUtils;
import com.rainer.pawel.intro._3_.IntUtilsException;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntUtils_Solution_Test {

    private final IntUtils intUtils = new IntUtils();

    @Test
    void shouldCalculateSummary() {
        // given
        int expectedSum = 10;
        List<Integer> l = List.of(1, 2, 3, 4);

        // when
        int actualSum = intUtils.sum(l);

        // then
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void shouldFindMaximum() {
        // given
        int expectedMax = 4;
        List<Integer> l = List.of(1, expectedMax, 2, 3, -1);

        // when
        int actualMax = intUtils.max(l);

        // then
        assertEquals(expectedMax, actualMax);
    }

    @Test
    void shouldThrowIntUtilsExceptionIfEmptyListPassedToMax() {
        // given
        List<Integer> l = Collections.emptyList();

        // expect
        assertThrows(IntUtilsException.class, () -> intUtils.max(l));
    }

    @Test
    void shouldFindMinimum() {
        // given
        int expectedMin = -6;
        List<Integer> l = List.of(1, expectedMin, 2, 3, -1);

        // when
        int actualMin = intUtils.min(l);

        // then
        assertEquals(expectedMin, actualMin);
    }

    @Test
    void shouldThrowIntUtilsExceptionIfEmptyListPassedToMin() {
        // given
        List<Integer> l = Collections.emptyList();

        // expect
        assertThrows(IntUtilsException.class, () -> intUtils.min(l));
    }

}