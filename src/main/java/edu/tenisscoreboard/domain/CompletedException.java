package edu.tenisscoreboard.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompletedException extends Exception{
    public final boolean firstPlayerWin;
}
