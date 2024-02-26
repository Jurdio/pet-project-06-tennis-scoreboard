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
        <input type="submit" value="Search">
        <input type="submit" value="Reset">
    </form>


    <ul class="match-list">
        <%-- Перебираємо матчі та виводимо їх у список --%>
        <c:forEach var="match" items="${requestScope.listOfMatches}">
            <li class="match-item">
                <div class="left-half">
                    <div class="first-player">
                            ${match.getFirstPlayer().getName()}
                    </div>
                    <div class="winner">
                        <c:if test="${not empty match.getWinner() and match.getWinner().equals(match.getFirstPlayer())}">
                            <img src="<%=request.getContextPath()%>/view/img/cup-600-600.png" alt="Trophy"
                                 class="trophy-icon">
                        </c:if>
                    </div>
                </div>
                <div>VS</div>
                <div class="right-half">
                    <div class="second-player">
                            ${match.getSecondPlayer().getName()}
                    </div>
                    <div class="winner">
                        <c:if test="${not empty match.getWinner() and match.getWinner().equals(match.getSecondPlayer())}">
                            <img src="<%=request.getContextPath()%>/view/img/cup-600-600.png" alt="Trophy"
                                 class="trophy-icon">
                        </c:if>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
    <div class="pagination-section">
        <c:if test="${currentPage > 1}">
            <a href="${pageContext.request.contextPath}/completed-matches?page=${requestScope.currentPage - 1}"><</a>
        </c:if>
        <span>${currentPage}</span>
        <c:if test="${currentPage < totalPages}">
            <a href="${pageContext.request.contextPath}/completed-matches?page=${requestScope.currentPage + 1}">></a>
        </c:if>


    </div>
</div>
</body>
</html>
