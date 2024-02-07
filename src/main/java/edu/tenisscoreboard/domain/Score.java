package edu.tenisscoreboard.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Score {
    private final int maxValue;
    private final int diff;
    @Getter
    private int firstPlayerScore;
    @Getter
    private int secondPlayerScore;

    void addPoint(boolean firstPlayerWin) throws CompletedException {
        if (firstPlayerWin){
            firstPlayerScore++;
        } else {
            secondPlayerScore++;
        }

        if ( (firstPlayerScore >= maxValue || secondPlayerScore >= maxValue)
        && Math.abs(firstPlayerScore - secondPlayerScore) >= diff){
            throw new CompletedException(firstPlayerScore > secondPlayerScore);
        }
    }

}
