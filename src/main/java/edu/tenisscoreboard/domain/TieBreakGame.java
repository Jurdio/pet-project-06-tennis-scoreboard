package edu.tenisscoreboard.domain;

import edu.tenisscoreboard.wrapper.IntegerWrapper;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import lombok.Getter;

@Getter
public class TieBreakGame extends GameScore<IntegerWrapper>{
    private final IntegerWrapper firstPlayerScore = new IntegerWrapper(0);
    private final IntegerWrapper secondPlayerScore = new IntegerWrapper(0);
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
