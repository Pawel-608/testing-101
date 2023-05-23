package com.rainer.pawel.project.domain;

import static com.rainer.pawel.project.domain.utils.EnsureUtils.ensureThat;

public class Price {

    private final int price;

    public Price(int price) {
        ensureThat(price >= 0, "Price must be positive");
        this.price = price;
    }

    public static Price of(int price) {
        return new Price(price);
    }

    public int asInt() {
        return price;
    }

    public int compareTo(Price otherPrice) {
        return Integer.compare(price, otherPrice.price);
    }

    @Override
    public String toString() {
        return String.valueOf(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price1 = (Price) o;

        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return price;
    }
}
