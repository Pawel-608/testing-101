package com.rainer.pawel.project.domain;

public class PriceRange {

    private final Price min;

    private final Price max;

    public PriceRange(Price min, Price max) {
        this.min = min;
        this.max = max;
    }

    public static PriceRange of(int min, int max) {
        return new PriceRange(
                Price.of(min),
                Price.of(max)
        );
    }


    public boolean contains(Price price) {
        return min.compareTo(price) <= 0 && max.compareTo(price) >= 0;
    }
}
