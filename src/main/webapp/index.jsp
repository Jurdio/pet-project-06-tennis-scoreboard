<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<style>
    <%@ include file="/view/css/index.css" %>
</style>
<head>
    <title>Tennis Scoreboard</title>
</head>
<body>
<header>
    <h1>TENNIS SCOREBOARD</h1>
</header>
<div class="main-container">
    <div class="button-container">
        <button onclick="redirectToCreateMatch()" class="button">CREATE NEW MATCH</button>
        <button onclick="redirectToCompletedMatchesPage()" class="button">COMPLETED MATCHES</button>
    </div>
</div>
<script>
    function redirectToCreateMatch() {
        window.location.href = '${pageContext.request.contextPath}/new-match';
    }

    function redirectToCompletedMatchesPage() {
        window.location.href = '${pageContext.request.contextPath}/completed-matches';
    }
</script>
</body>
</html>