package edu.tenisscoreboard.domain;

import edu.tenisscoreboard.domain.score.MatchScore;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class OngoingMatch {
    private final UUID id;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private Player winner;
    private boolean serving;
    private MatchScore matchScore;
}