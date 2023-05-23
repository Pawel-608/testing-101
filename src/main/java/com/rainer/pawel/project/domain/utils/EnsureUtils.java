package com.rainer.pawel.project.domain.utils;

public final class EnsureUtils {
    private EnsureUtils() {
    }

    public static void ensureThat(boolean condition, String message) {
        if (!condition) {
            throw new AnimalCatalogException(message);
        }
    }
}
