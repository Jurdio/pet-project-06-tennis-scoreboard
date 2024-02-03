package edu.tenisscoreboard.service;

import edu.tenisscoreboard.domain.OngoingMatch;
import edu.tenisscoreboard.domain.Player;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


@Getter
public class OngoingMatchService {
    private static volatile OngoingMatchService INSTANCE;
    private final Map<UUID, OngoingMatch> ongoingMatches;

    private OngoingMatchService() {
        ongoingMatches = new ConcurrentHashMap<>();
    }

    public static OngoingMatchService getInstance() {
        if (INSTANCE == null) {
            synchronized (OngoingMatchService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OngoingMatchService();
                }
            }
        }
        return INSTANCE;
    }

    public UUID createMatch(Player firstPlayer, Player secondPlayer) {
        UUID id = UUID.randomUUID();

        OngoingMatch ongoingMatch = OngoingMatch.builder()
                .id(id)
                .firstPlayer(firstPlayer)
                .secondPlayer(secondPlayer)
                .build();

        ongoingMatches.put(id, ongoingMatch);

        return id;
    }
}
