package edu.tenisscoreboard.service;

import edu.tenisscoreboard.domain.CompletedException;
import edu.tenisscoreboard.domain.MatchScore;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public class MatchScoreCalculationService {
    private final MatchScore matchScore;

    public void addPoint(boolean isPointForFirstPlayer){
        try {
            matchScore.addPoint(isPointForFirstPlayer);
        } catch (CompletedException e) {
            throw new RuntimeException(e);
        }
    }




}
