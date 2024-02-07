package edu.tenisscoreboard.domain;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class MatchScore {
    private static final int MATCH_MAX_SCORE = 2;
    private static final int MATCH_DIFF = 1;
    private static final int SET_MAX_SCORE = 6;
    private static final int SET_DIFF = 2;
    private static final int GAME_MAX_SCORE = 5;
    private static final int GAME_DIFF = 2;

    private final Score match;
    private final LinkedList<Score> sets;
    private Score currentGame;

    public MatchScore(){
        match = new Score(MATCH_MAX_SCORE, MATCH_DIFF);
        sets = new LinkedList<>();
        sets.add(new Score(SET_MAX_SCORE, SET_DIFF));
        currentGame = new Score(GAME_MAX_SCORE, GAME_DIFF);
    }

    public void addPoint(boolean firstPlayerWin) throws CompletedException{
        try {
            currentGame.addPoint(firstPlayerWin);
        } catch (CompletedException gameCompleted) {
            try {
                sets.getLast().addPoint(gameCompleted.firstPlayerWin);
            } catch (CompletedException setCompleted) {
                match.addPoint(setCompleted.firstPlayerWin);
                sets.add(new Score(SET_MAX_SCORE,SET_DIFF));
            }
            currentGame = new Score(GAME_MAX_SCORE, GAME_DIFF);
        }
    }
}
