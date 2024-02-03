package edu.tenisscoreboard.domain;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Player {
    private int id;
    private String name;
}
