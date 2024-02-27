package edu.tenisscoreboard.domain.score;

import lombok.Getter;

@Getter
public abstract class GameScore<T extends ScoreValueProvider> implements Scoring {
    protected T firstPlayerScore;
    protected T secondPlayerScore;
}

