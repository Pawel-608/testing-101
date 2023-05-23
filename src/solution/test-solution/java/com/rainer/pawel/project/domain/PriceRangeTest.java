package com.rainer.pawel.project.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceRangeTest {

    @ParameterizedTest
    @CsvSource(useHeadersInDisplayName = true,
            delimiter = '|', textBlock = """
            PRICE | IS_IN_RANGE
             3    | true
             1    | true
             5    | true
             0    | false
             10   | false
            """)
    void shouldTestIfPriceIsInRange(int priceToCheck, boolean isInRange) {
        // given
        PriceRange testPriceRange = PriceRange.of(1, 5);

        // then
        assertEquals(testPriceRange.contains(Price.of(priceToCheck)), isInRange);
    }
}