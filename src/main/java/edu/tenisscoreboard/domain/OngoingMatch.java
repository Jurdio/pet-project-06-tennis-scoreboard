package edu.tenisscoreboard.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class OngoingMatch {
    private final UUID id;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private int serving;
    private MatchScore matchScore;
}