package edu.tenisscoreboard.domain.game;

import edu.tenisscoreboard.domain.ScoreValueProvider;
import edu.tenisscoreboard.domain.Scoring;
import lombok.Getter;

@Getter
public abstract class GameScore<T extends ScoreValueProvider> implements Scoring {
    protected T firstPlayerScore;
    protected T secondPlayerScore;
}

