package edu.tenisscoreboard.service;

import edu.tenisscoreboard.domain.CompletedException;
import edu.tenisscoreboard.domain.MatchSc;
import edu.tenisscoreboard.domain.OngoingMatch;
import lombok.RequiredArgsConstructor;

import java.util.UUID;


public class MatchScoreCalculationService {

    public void addPoint(String id, String value){
        OngoingMatch ongoingMatch = OngoingMatchService.getInstance().getMatch(UUID.fromString(id));
        try {
            ongoingMatch.getMatchSc().addPoint(Boolean.parseBoolean(value));
        } catch (CompletedException e) {
            throw new RuntimeException(e);
        }
    }




}
