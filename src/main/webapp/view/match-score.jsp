<%@ page import="edu.tenisscoreboard.domain.OngoingMatch" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<style>
    <%@ include file="/view/css/match-score.css" %>
</style>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <h1>ONGOING MATCH</h1>
</header>
<div class="main-container">
    <div class="border-container">
        <div class="gameplay-container">
            <div class="info-container">
                <div class="player-name-container">
                    <h2>${ongoingMatch.getFirstPlayer().getName()}</h2>
                </div>
                <div class="gameplay-info-container">
                    <div class="serve-container">
                        <c:if test="${ongoingMatch.getFirstPlayer().getId() == ongoingMatch.getServing()}">
                            <div class="serve-point"></div>
                        </c:if>
                    </div>
                    <div class="game-container">
                        <span id="firstPlayerScore">${ongoingMatch.getMatchScore().getCurrentGame().getFirstPlayerScore()}</span>
                    </div>
                    <div class="first-set">
                        <c:if test="${ongoingMatch.matchScore.sets[0] ne null} ne null">
                            ${ongoingMatch.getMatchScore().getSets().get(0).getFirstPlayerScore()}
                        </c:if>
                    </div>
                    <div class="second-set"></div>
                    <div class="third-set"></div>
                </div>
            </div>
            <div class="info-container">
                <div class="player-name-container"></div>
                <div class="gameplay-text-container">
                    <div style="margin-left: 15px"><h6>SERVING</h6></div>
                    <div><h3>GAME</h3></div>
                    <div style="margin-left: 30px"><h5>SET 1</h5></div>
                    <div><h5>SET 2</h5></div>
                    <div><h5>SET 3</h5></div>
                </div>
            </div>
            <div class="info-container">
                <div class="player-name-container">
                    <h2>${ongoingMatch.getSecondPlayer().getName()}</h2>
                </div>
                <div class="gameplay-info-container">
                    <div class="serve-container">
                        <c:if test="${ongoingMatch.getSecondPlayer().getId() == ongoingMatch.getServing()}">
                            <div class="serve-point"></div>
                        </c:if>
                    </div>
                    <div class="game-container">
                        <span>${ongoingMatch.getMatchScore().getCurrentGame().getSecondPlayerScore()}</span>
                    </div>
                    <div class="first-set">
                        <c:if test="${ongoingMatch.matchScore.sets[0] ne null}">
                            ${ongoingMatch.matchScore.sets[0].secondPlayerScore}
                        </c:if>
                    </div>
                    <div class="second-set">
                        <c:if test="${ongoingMatch.matchScore.sets[1] ne null}">
                            ${ongoingMatch.matchScore.sets[1].secondPlayerScore}
                        </c:if>
                    </div>
                    <div class="third-set">
                        <c:if test="${ongoingMatch.matchScore.sets[2] ne null}">
                            ${ongoingMatch.matchScore.sets[1].secondPlayerScore}
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <div class="button-container">
            <form method="post">
                <button class="button-game" value="false">POINT FOR PLAYER 1</button>
            </form>
            <button class="button-game">CONTINUE</button>
            <button class="button-game">POINT FOR PLAYER 2</button>
        </div>
        <div class="matchId-container">
            <h6>MATCH ID : ${ongoingMatch.getId()} </h6>
        </div>
    </div>
</div>
</body>
</html>
