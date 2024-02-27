package edu.tenisscoreboard.domain.score;

import edu.tenisscoreboard.exception.CompletedException;

public interface Scoring {
    void addPoint(boolean firstPlayerWin) throws CompletedException;
}
