package edu.tenisscoreboard.wrapper;

import edu.tenisscoreboard.domain.ScoreValueProvider;

public class IntegerWrapper implements ScoreValueProvider {
    private Integer value;
    public IntegerWrapper(Integer value) {
        this.value = value;
    }
    public void add(Integer addend) {
        this.value += addend;
    }
    @Override
    public String getValue() {
        return String.valueOf(value);
    }
    public Integer getInteger() {
        return value;
    }
}

