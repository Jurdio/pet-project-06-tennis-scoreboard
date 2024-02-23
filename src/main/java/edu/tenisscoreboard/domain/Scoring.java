package edu.tenisscoreboard.domain;

public interface Scoring {
    void addPoint(boolean firstPlayerWin) throws CompletedException;
}
