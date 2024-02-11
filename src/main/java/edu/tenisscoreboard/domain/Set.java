package edu.tenisscoreboard.domain;

import edu.tenisscoreboard.wrapper.IntegerWrapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Set extends GameScore<IntegerWrapper>{
    private final int diff;
    private final IntegerWrapper firstPlayerScore = new IntegerWrapper(0);
    private final IntegerWrapper secondPlayerScore = new IntegerWrapper(0);

    public void addPoint(boolean firstPlayerWin) throws CompletedException {
        if (firstPlayerWin) {
            firstPlayerScore.add(1);
        } else {
            secondPlayerScore.add(1);
        }
        if ((Math.abs(firstPlayerScore.getInteger() - secondPlayerScore.getInteger()) >= 2 && (firstPlayerScore.getInteger() >= 6 || secondPlayerScore.getInteger() >= 6))){
            throw new CompletedException(firstPlayerScore.getInteger() > secondPlayerScore.getInteger());
        }
        if (firstPlayerScore.getInteger() == 7 && secondPlayerScore.getInteger() == 6){
            throw new CompletedException(firstPlayerScore.getInteger() > secondPlayerScore.getInteger());
        }
        if (firstPlayerScore.getInteger() == 6 && secondPlayerScore.getInteger() == 7){
            throw new CompletedException(firstPlayerScore.getInteger() > secondPlayerScore.getInteger());
        }
    }
    GameScore<?> createGame() {
        return firstPlayerScore.getInteger() == 6 && secondPlayerScore.getInteger() == 6 ? new TieBreakGame() : new Game(2);
    }
}
