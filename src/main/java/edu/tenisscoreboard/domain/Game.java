package edu.tenisscoreboard.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Game extends GameScore<Point> {
    private final int diff;
    @Getter
    private Point firstPlayerScore = Point.LOVE;
    @Getter
    private Point secondPlayerScore = Point.LOVE;
    @Override
    public void addPoint(boolean firstPlayerWin) throws CompletedException {
        if (firstPlayerScore.ordinal() >= Point.FORTY.ordinal() && secondPlayerScore.ordinal() >= Point.FORTY.ordinal()) {
            if (firstPlayerScore == Point.ADVANTAGE) {
                if (firstPlayerWin) {
                    throwMatch();
                } else {
                    firstPlayerScore = firstPlayerScore.previous();
                }
            } else if (secondPlayerScore == Point.ADVANTAGE) {
                if (firstPlayerWin) {
                    secondPlayerScore = secondPlayerScore.previous();
                } else {
                    throwMatch();
                }
            } else {
                if (firstPlayerWin) {
                    firstPlayerScore = firstPlayerScore.next();
                } else {
                    secondPlayerScore = secondPlayerScore.next();
                }
            }

        } else if (isGamePoint()) {
            if (firstPlayerScore == Point.FORTY) {
                if (firstPlayerWin) {
                    throwMatch();
                } else {
                    secondPlayerScore = secondPlayerScore.next();
                }
            } else {
                if (firstPlayerWin) {
                    firstPlayerScore = firstPlayerScore.next();
                } else {
                    throwMatch();
                }
            }
        } else {
            if (firstPlayerWin) {
                firstPlayerScore = firstPlayerScore.next();
            } else {
                secondPlayerScore = secondPlayerScore.next();
            }
        }

    }


    boolean isGamePoint() {
        if (firstPlayerScore == Point.FORTY || secondPlayerScore == Point.FORTY) {
            return true;
        }
        return false;
    }

    void throwMatch() throws CompletedException {
        throw new CompletedException(firstPlayerScore.ordinal() > secondPlayerScore.ordinal());
    }
}