package edu.tenisscoreboard.service;

import edu.tenisscoreboard.domain.MatchScore;
import edu.tenisscoreboard.domain.OngoingMatch;
import edu.tenisscoreboard.domain.Player;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


@Getter
@Slf4j
public class OngoingMatchService {
    private static volatile OngoingMatchService INSTANCE;
    private final Map<UUID, OngoingMatch> ongoingMatches = new ConcurrentHashMap<>();;

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
                .serving(new Random().nextInt(2) == 0 ? firstPlayer.getId() : secondPlayer.getId())
                .matchSc(new MatchScore())
                .build();
        log.debug("{}",ongoingMatch.getServing());

        ongoingMatches.put(id, ongoingMatch);

        return id;
    }

    public OngoingMatch getMatch (UUID id){
        return ongoingMatches.get(id);
    }


}
