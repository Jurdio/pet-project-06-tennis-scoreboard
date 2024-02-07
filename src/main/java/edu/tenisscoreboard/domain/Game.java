package edu.tenisscoreboard.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Game {
    private final int diff;
    @Getter
    private Point firstPlayerScore;
    @Getter
    private Point secondPlayerScore;

    void addPoint (boolean firstPlayerWin) throws CompletedException {
        if (firstPlayerWin) {
            firstPlayerScore.next();
        } else {
            secondPlayerScore.next();
        }
    }
}
