package edu.tenisscoreboard.domain;

import edu.tenisscoreboard.persistence.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Match {
    private int id;
    private Player firstPlayer;
    private Player secondPlayer;
    private Player winner;
}
