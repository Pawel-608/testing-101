package com.rainer.pawel.project.domain;

import com.rainer.pawel.project.domain.utils.AnimalCatalogException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceTest {

    @Test
    void shouldThrowIfNegativeValue() {
        assertThrows(AnimalCatalogException.class, () -> new Price(-1));
    }
}