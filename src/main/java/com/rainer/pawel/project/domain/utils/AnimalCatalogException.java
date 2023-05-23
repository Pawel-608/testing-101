package com.rainer.pawel.project.domain.utils;

public class AnimalCatalogException extends RuntimeException {

    public AnimalCatalogException(String message) {
        super(message);
    }

    public AnimalCatalogException(Throwable cause) {
        super(cause);
    }

    public AnimalCatalogException(String message, Throwable cause) {
        super(message, cause);
    }

}
