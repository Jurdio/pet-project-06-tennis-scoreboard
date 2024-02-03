package edu.tenisscoreboard.controller.dto;

import edu.tenisscoreboard.domain.Player;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class MatchDTO {
    private Player firstPlayer;
    private Player secondPlayer;
}
