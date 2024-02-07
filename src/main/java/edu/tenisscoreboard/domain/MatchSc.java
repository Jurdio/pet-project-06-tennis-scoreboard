package edu.tenisscoreboard.domain;

import java.util.LinkedList;

public class MatchSc {
    private static final int MATCH_MAX_SCORE = 2;
    private static final int MATCH_DIFF = 1;
    private static final int SET_MAX_SCORE = 7;
    private static final int SET_DIFF = 2;
    private static final int GAME_DIFF = 2;
    private Score match;
    private LinkedList<Set> sets;
    private Game game;

    public MatchSc(){
        match = new Score(MATCH_MAX_SCORE,MATCH_DIFF);
        sets = new LinkedList<>();
        sets.add(new Set(SET_DIFF));
        game = new Game(GAME_DIFF);
    }

    public void addPoint (boolean firstPlayerWin) throws CompletedException {
        try {
            game.addPoint(firstPlayerWin);
        } catch (CompletedException gameCompleted) {
            try {
                sets.getLast().addPoint(gameCompleted.firstPlayerWin);
            } catch (CompletedException setCompleted) {
                match.addPoint(setCompleted.firstPlayerWin);
                sets.add(new Set(2));
            }
        }
    }
}
