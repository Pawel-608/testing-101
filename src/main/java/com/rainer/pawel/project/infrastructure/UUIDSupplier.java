package com.rainer.pawel.project.infrastructure;

import java.util.UUID;
import java.util.function.Supplier;

public class UUIDSupplier implements Supplier<UUID> {
    @Override
    public UUID get() {
        return UUID.randomUUID();
    }
}
