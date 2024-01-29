package edu.tenisscoreboard.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Match {
    private int firstPlayerId;
    private int secondPlayerId;
    private Score score;
}
