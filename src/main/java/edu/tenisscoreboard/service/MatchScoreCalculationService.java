package edu.tenisscoreboard.service;

import edu.tenisscoreboard.domain.Match;
import edu.tenisscoreboard.domain.OngoingMatch;
import edu.tenisscoreboard.exception.CompletedException;

import java.util.UUID;

public class MatchScoreCalculationService {
    private final FinishedMatchesPersistenceService finishedMatchesPersistenceService = new FinishedMatchesPersistenceService();

    public void addPoint(String id, String value) {
        OngoingMatch ongoingMatch = OngoingMatchService.getInstance().getMatch(UUID.fromString(id));
        try {
            ongoingMatch.getMatchScore().addPoint(Boolean.parseBoolean(value));
            ongoingMatch.setServing(!ongoingMatch.isServing());
        } catch (CompletedException matchCompleted) {
            ongoingMatch.setWinner(matchCompleted.firstPlayerWin ? ongoingMatch.getFirstPlayer() : ongoingMatch.getSecondPlayer());

            finishedMatchesPersistenceService.saveMatch(Match.builder()
                    .firstPlayer(ongoingMatch.getFirstPlayer())
                    .secondPlayer(ongoingMatch.getSecondPlayer())
                    .winner(ongoingMatch.getWinner())
                    .build());
        }
    }
}
