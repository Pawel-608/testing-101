package com.rainer.pawel.intro._3_;

import java.util.List;

public class IntUtils {
    public int sum(List<Integer> l) {
        return l.stream()
                .mapToInt(i -> i)
                .sum();
    }

    public int max(List<Integer> l) {
        return l.stream()
                .mapToInt(i -> i)
                .max()
                .orElseThrow(() -> new IntUtilsException("Cannot find maximum"));
    }

    public int min(List<Integer> l) {
        return l.stream()
                .mapToInt(i -> i)
                .min()
                .orElseThrow(() -> new IntUtilsException("Cannot find minimum"));
    }
}
