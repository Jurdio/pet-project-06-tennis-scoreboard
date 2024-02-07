package edu.tenisscoreboard.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CompletedException extends Exception{
    final boolean firstPlayerWin;
}
