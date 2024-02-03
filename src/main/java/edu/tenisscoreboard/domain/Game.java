package edu.tenisscoreboard.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public class Game {
    @Getter
    @RequiredArgsConstructor
    public enum Score {
        LOVE("0"), FIFTEEN("15"), THIRTY("30"), FORTY("40"), ADVANTAGE("AD");

        private final String value;
    }
    private Score firstPlayerScore = Score.LOVE;
    private Score secondPlayerScore = Score.LOVE;








}
