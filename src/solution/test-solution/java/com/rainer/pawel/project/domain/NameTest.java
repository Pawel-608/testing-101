package com.rainer.pawel.project.domain;

import com.rainer.pawel.project.domain.utils.AnimalCatalogException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void shouldThrowIfNameIsNotOnlyLetters() {
        assertThrows(AnimalCatalogException.class, () -> Name.of("aaa123"));
    }
}