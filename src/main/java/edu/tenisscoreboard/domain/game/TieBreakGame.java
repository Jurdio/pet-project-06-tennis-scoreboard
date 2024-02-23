package edu.tenisscoreboard.domain.game;

import edu.tenisscoreboard.domain.CompletedException;
import edu.tenisscoreboard.domain.game.GameScore;
import edu.tenisscoreboard.wrapper.IntegerWrapper;

public class TieBreakGame extends GameScore<IntegerWrapper> {
    TieBreakGame(){
        super();
        super.firstPlayerScore = new IntegerWrapper(0);
        super.secondPlayerScore = new IntegerWrapper(0);
    }
    @Override
    public void addPoint(boolean firstPlayerWin) throws CompletedException {
        if (firstPlayerWin) {
            firstPlayerScore.add(1);
        } else {
            secondPlayerScore.add(1);
        }

        if (Math.abs(firstPlayerScore.getInteger() - secondPlayerScore.getInteger()) >= 2) {
            if (firstPlayerScore.getInteger() >= 7 || secondPlayerScore.getInteger() >= 7){
                throw new CompletedException(firstPlayerScore.getInteger() > secondPlayerScore.getInteger());
            }
        }
    }
}
