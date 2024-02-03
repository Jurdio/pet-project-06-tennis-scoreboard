package edu.tenisscoreboard.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class OngoingMatch {
    private UUID id;
    private Player firstPlayer;
    private Player secondPlayer;
}
