package edu.tenisscoreboard.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Set {

    private final int diff;
    @Getter
    private int firstPlayerScore;
    @Getter
    private int secondPlayerScore;

    void addPoint (boolean firstPlayerWin) throws CompletedException {
        if (firstPlayerWin) {
            firstPlayerScore++;
        } else {
            secondPlayerScore++;
        }
        if (Math.abs(firstPlayerScore - secondPlayerScore) >= diff && (firstPlayerScore >= 6 || secondPlayerScore >= 6)){
            throw new CompletedException(firstPlayerScore > secondPlayerScore);
        }
    }
}
