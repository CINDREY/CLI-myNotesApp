package com.example.util;

import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
public class IdGenerator {
    private AtomicLong counter;

    public IdGenerator(Set<Long> existingIds) {
        long maxId = existingIds.stream().mapToLong(v -> v).max().orElse(0L);
        counter = new AtomicLong(maxId);
    }

    public long incrementAndGet() {
        return counter.incrementAndGet();
    }
}



