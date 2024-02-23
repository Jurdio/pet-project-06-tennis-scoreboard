package edu.tenisscoreboard.domain;

import edu.tenisscoreboard.domain.game.Game;
import edu.tenisscoreboard.domain.game.GameScore;
import edu.tenisscoreboard.domain.game.Set;
import lombok.Data;

import java.util.LinkedList;

@Data
public class MatchScore {
    private static final int MATCH_MAX_SCORE = 2;
    private static final int MATCH_DIFF = 1;
    private static final int SET_MAX_SCORE = 7;
    private static final int SET_DIFF = 2;
    private static final int GAME_DIFF = 2;
    private int firstPlayerScore;
    private int secondPlayerScore;

    private LinkedList<Set> sets;
    private GameScore<?> game;


    public MatchScore() {
        sets = new LinkedList<>();
        sets.add(new Set());
        game = new Game();
        firstPlayerScore = 0;
        secondPlayerScore = 0;
    }

    public void addPoint(boolean firstPlayerWin) throws CompletedException {
        try {
            game.addPoint(firstPlayerWin);
        } catch (CompletedException gameCompleted) {
            try {
                sets.getLast().addPoint(gameCompleted.firstPlayerWin);
            } catch (CompletedException setCompleted) {
                if (setCompleted.firstPlayerWin) {
                    firstPlayerScore++;
                } else {
                    secondPlayerScore++;
                }

                if (firstPlayerScore == 2 || secondPlayerScore == 2) {
                    throw new CompletedException(firstPlayerScore > secondPlayerScore);
                }
                sets.addLast(new Set());
            }
            game = sets.getLast().createGame();
        }
    }

}
