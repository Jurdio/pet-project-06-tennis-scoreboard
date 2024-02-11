package edu.tennisscoreboard.service;

import edu.tenisscoreboard.domain.MatchScore;
import edu.tenisscoreboard.domain.Player;
import edu.tenisscoreboard.service.MatchScoreCalculationService;
import edu.tenisscoreboard.service.OngoingMatchService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class MatchScoreCalculationServiceTest {
    MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService();
    UUID ongoingMatchId;
    MatchScore matchScore;
    Player player1 = Player.builder()
            .id(1)
            .name("Tom Hiper")
            .build();
    Player player2 = Player.builder()
            .id(2)
            .name("Dick Timer")
            .build();

    @BeforeEach
    public void init() {
        ongoingMatchId = OngoingMatchService.getInstance().createMatch(player1, player2);
        matchScore = OngoingMatchService.getInstance().getMatch(ongoingMatchId).getMatchScore();
    }

    @Test
    public void correctCalculationPoints() {
        Assertions.assertEquals("0", matchScore.getGame().getFirstPlayerScore().getValue());
        Assertions.assertEquals("0", matchScore.getGame().getSecondPlayerScore().getValue());

        matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(true));
        matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(false));

        Assertions.assertEquals("15", matchScore.getGame().getFirstPlayerScore().getValue());
        Assertions.assertEquals("15", matchScore.getGame().getSecondPlayerScore().getValue());

        matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(true));
        matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(false));

        Assertions.assertEquals("30", matchScore.getGame().getFirstPlayerScore().getValue());
        Assertions.assertEquals("30", matchScore.getGame().getSecondPlayerScore().getValue());

        matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(true));
        matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(false));

        Assertions.assertEquals("40", matchScore.getGame().getFirstPlayerScore().getValue());
        Assertions.assertEquals("40", matchScore.getGame().getSecondPlayerScore().getValue());
    }

    @Test
    public void firstPlayerWinGame() {
        Assertions.assertEquals("0", matchScore.getSets().getLast().getFirstPlayerScore().getValue());

        for (int i = 0; i < 4; i++) {
            matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(true));
        }

        Assertions.assertEquals("0", matchScore.getGame().getFirstPlayerScore().getValue());
        Assertions.assertEquals("1", matchScore.getSets().getLast().getFirstPlayerScore().getValue());
    }

    @Test
    public void advantageGame() {
        for (int i = 0; i < 4; i++) {
            matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(true));
            matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(false));
        }

        Assertions.assertEquals("40", matchScore.getGame().getFirstPlayerScore().getValue());
        Assertions.assertEquals("40", matchScore.getGame().getSecondPlayerScore().getValue());

        matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(true));

        Assertions.assertEquals("AD", matchScore.getGame().getFirstPlayerScore().getValue());
        Assertions.assertEquals("40", matchScore.getGame().getSecondPlayerScore().getValue());

        matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(false));

        Assertions.assertEquals("40", matchScore.getGame().getFirstPlayerScore().getValue());
        Assertions.assertEquals("40", matchScore.getGame().getSecondPlayerScore().getValue());

        matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(false));

        Assertions.assertEquals("40", matchScore.getGame().getFirstPlayerScore().getValue());
        Assertions.assertEquals("AD", matchScore.getGame().getSecondPlayerScore().getValue());

        matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(true));

        Assertions.assertEquals("40", matchScore.getGame().getFirstPlayerScore().getValue());
        Assertions.assertEquals("40", matchScore.getGame().getSecondPlayerScore().getValue());
    }

    @Test
    public void firstPlayerWinInAdvantageGameAndScoreReset() {
        advantageGame();

        matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(true));
        matchScoreCalculationService.addPoint(String.valueOf(ongoingMatchId), String.valueOf(true));

        Assertions.assertEquals("0", matchScore.getGame().getFirstPlayerScore().getValue());
        Assertions.assertEquals("0", matchScore.getGame().getSecondPlayerScore().getValue());
        Assertions.assertEquals("1", matchScore.getSets().getLast().getFirstPlayerScore().getValue());
    }
}
