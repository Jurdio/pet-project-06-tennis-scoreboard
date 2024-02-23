package edu.tenisscoreboard.domain.game;

import edu.tenisscoreboard.domain.CompletedException;
import edu.tenisscoreboard.wrapper.IntegerWrapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class Set extends GameScore<IntegerWrapper> {
    public Set() {
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



        if (Math.abs(firstPlayerScore.getInteger() - secondPlayerScore.getInteger()) >= 2 && (firstPlayerScore.getInteger() >= 6 || secondPlayerScore.getInteger() >= 6)) {
            throw new CompletedException(firstPlayerScore.getInteger() > secondPlayerScore.getInteger());
        }
        if (firstPlayerScore.getInteger() == 7 && secondPlayerScore.getInteger() == 6) {
            throw new CompletedException(firstPlayerScore.getInteger() > secondPlayerScore.getInteger());
        }
        if (firstPlayerScore.getInteger() == 6 && secondPlayerScore.getInteger() == 7) {
            throw new CompletedException(firstPlayerScore.getInteger() > secondPlayerScore.getInteger());
        }
    }

    public GameScore<?> createGame() {
        return firstPlayerScore.getInteger() == 6 && secondPlayerScore.getInteger() == 6 ? new TieBreakGame() : new Game();
    }
}
