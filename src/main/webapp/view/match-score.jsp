<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 03.02.2024
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <h2>${OngoingMatch.getFirstPlayer().getName()}</h2>
                </div>
                <div class="gameplay-info-container">
                    <div class="serve-container">
                        <div class="serve-point"></div>
                    </div>
                    <div class="game-container"></div>
                    <div class="first-set"></div>
                    <div class="second-set"></div>
                    <div class="third-set"></div>
                </div>
            </div>
            <div class="info-container">
                <div class="player-name-container"></div>
                    <div class="gameplay-text-container">
                        <div><h6>SERVING</h6></div>
                        <div><h3>GAME</h3></div>
                        <div><h5>SET 1</h5></div>
                        <div><h5>SET 2</h5></div>
                        <div><h5>SET 3</h5></div>
                    </div>
            </div>
            <div class="info-container">
                <div class="player-name-container">
                    <h2>${OngoingMatch.getSecondPlayer().getName()}</h2>
                </div>
                <div class="gameplay-info-container">
                    <div class="serve-container">
                        <div class="serve-point"></div>
                    </div>
                    <div class="game-container"></div>
                    <div class="first-set"></div>
                    <div class="second-set"></div>
                    <div class="third-set"></div>
                </div>
            </div>
        </div>
        <div>
            <button>POINT FOR PLAYER 1</button>
            <button>CONTINUE</button>
            <button>POINT FOR PLAYER 2</button>
        </div>
        <div class="matchId-container">
            <h6>MATCH ID : ${OngoingMatch.getId()} </h6>
        </div>
    </div>
</div>

</body>
</html>
