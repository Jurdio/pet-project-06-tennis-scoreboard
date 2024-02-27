package edu.tenisscoreboard.domain.score;

import edu.tenisscoreboard.exception.CompletedException;

public class Game extends GameScore<Point> {
    public Game() {
        super();
        super.firstPlayerScore = Point.LOVE;
        super.secondPlayerScore = Point.LOVE;
    }

    @Override
    public void addPoint(boolean firstPlayerWin) throws CompletedException {
        if (isAdvantage()) {
            advantageGameplay(firstPlayerWin);
        } else if (isGamePoint()) {
            gamePointGameplay(firstPlayerWin);
        } else {
            defaultGameplay(firstPlayerWin);
        }
    }


    private boolean isGamePoint() {
        return firstPlayerScore == Point.FORTY || secondPlayerScore == Point.FORTY;
    }

    private boolean isAdvantage() {
        return firstPlayerScore.ordinal() >= Point.FORTY.ordinal() && secondPlayerScore.ordinal() >= Point.FORTY.ordinal();
    }

    private void gamePointGameplay(boolean firstPlayerWin) throws CompletedException {
        if (firstPlayerScore == Point.FORTY) {
            if (firstPlayerWin) {
                finishGame();
            } else {
                secondPlayerScore = secondPlayerScore.next();
            }
        } else {
            if (firstPlayerWin) {
                firstPlayerScore = firstPlayerScore.next();
            } else {
                finishGame();
            }
        }
    }

    private void advantageGameplay(boolean firstPlayerWin) throws CompletedException {
        if (firstPlayerScore == Point.ADVANTAGE) {
            if (firstPlayerWin) {
                finishGame();
            } else {
                firstPlayerScore = firstPlayerScore.previous();
            }
        } else if (secondPlayerScore == Point.ADVANTAGE) {
            if (firstPlayerWin) {
                secondPlayerScore = secondPlayerScore.previous();
            } else {
                finishGame();
            }
        } else {
            if (firstPlayerWin) {
                firstPlayerScore = firstPlayerScore.next();
            } else {
                secondPlayerScore = secondPlayerScore.next();
            }
        }
    }

    private void defaultGameplay(boolean firstPlayerWin) throws CompletedException {
        if (firstPlayerWin) {
            firstPlayerScore = firstPlayerScore.next();
        } else {
            secondPlayerScore = secondPlayerScore.next();
        }
    }

    private void finishGame() throws CompletedException {
        boolean result = firstPlayerScore.ordinal() > secondPlayerScore.ordinal();
        firstPlayerScore = Point.LOVE;
        secondPlayerScore = Point.LOVE;
        throw new CompletedException(result);
    }
}