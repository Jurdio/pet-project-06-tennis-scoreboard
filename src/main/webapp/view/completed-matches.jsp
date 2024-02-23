<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<style>
    <%@ include file="/view/css/completed-matches.css" %>
    <%@ include file="/view/css/match-score.css" %>
</style>
<head>
    <title>Title</title>
</head>
<header>
    <h1>COMPLETED MATCHES</h1>
</header>
<body>
<div class="main-container">
    <form action="${pageContext.request.contextPath}/completed-matches" method="get">
        <label for="playerName">Filter by Player Name:</label>
        <input type="text" id="playerName" name="filter_by_player_name">
        <input type="submit" value="Filter">
    </form>

    <ul class="match-list">
        <%-- Перебираємо матчі та виводимо їх у список --%>
        <c:forEach var="match" items="${requestScope.listOfMatches}">
            <li class="match-item">
                <div class="player-info first-player">
                        ${match.getFirstPlayer().getName()}
                    <div class="winner">
                        <c:if test="${not empty match.getWinner() and match.getWinner().equals(match.getFirstPlayer())}">
                            <img src="<%=request.getContextPath()%>/view/cup-600-600.png" alt="Trophy" width="20" height="20">
                        </c:if>
                    </div>
                </div>
                <div class="player-info second-player">
                        ${match.getSecondPlayer().getName()}
                    <div class="winner">
                        <c:if test="${not empty match.getWinner() and match.getWinner().equals(match.getSecondPlayer())}">
                            <img src="<%=request.getContextPath()%>/view/cup-600-600.png" alt="Trophy" width="20" height="20">
                        </c:if>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
