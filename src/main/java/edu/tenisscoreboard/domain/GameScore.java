package edu.tenisscoreboard.domain;

import lombok.Getter;

@Getter
public abstract class GameScore<T extends ScoreValueProvider> {
    T firstPlayerScore;
    T secondPlayerScore;
    public abstract void addPoint(boolean firstPlayerWin) throws CompletedException;
}

