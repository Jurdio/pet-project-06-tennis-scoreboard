package edu.tenisscoreboard.service;

import edu.tenisscoreboard.domain.CompletedException;
import edu.tenisscoreboard.domain.MatchSc;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
public class MatchScoreCalculationService {
    private final MatchSc matchSc;

    public void addPoint(boolean isPointForFirstPlayer){
        try {
            matchSc.addPoint(isPointForFirstPlayer);
        } catch (CompletedException e) {
            throw new RuntimeException(e);
        }
    }




}
