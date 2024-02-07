package edu.tenisscoreboard.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum Point {
    LOVE("0"), FIFTEEN("15"), THIRTY("30"), FORTY("40"), ADVANTAGE("AD");

    public Point next() {
        if (this == ADVANTAGE) {
            throw new IllegalArgumentException("Can`t call next() on Advantage");
        } else {
            return Point.values()[this.ordinal() + 1];
        }

    }
    @Getter
    private final String value;

}
