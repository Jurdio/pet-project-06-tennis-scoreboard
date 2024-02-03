<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 29.01.2024
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    <%@ include file="/view/css/new-match.css" %>
    <%@ include file="/view/css/index.css" %>
</style>
<head>
    <title>Tennis Scoreboard</title>
    <script>

    </script>
</head>
<body>
<header>
    <h1>NEW MATCH</h1>
</header>
<div class="main-container">
    <div class="input-container">
        <form class="form-container" action="${pageContext.request.contextPath}/new-match" method="post" onsubmit="return validateForm()" accept-charset="UTF-8">
            <label for="player1">Player 1:</label>
            <input type="text" name="player1" id="player1"><br>
            <label for="player2">Player 2:</label>
            <input type="text" name="player2" id="player2"><br>
            <button class="button-start" type="submit">START GAME</button>
            <button class="button-start" onclick="redirectToMain()">BACK TO MENU</button>
        </form>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/">Return to main page</a>
    </div>
</div>
<script>
    function validateForm() {
        const input1 = document.getElementById("player1").value;
        if (input1 === "") {
            alert("Input name for the first player");
            return false;
        }

        const input2 = document.getElementById("player2").value;
        if (input2 === "") {
            alert("Input name for the second player");
            return false;
        }

        return true;
    }
    function redirectToMatchScore() {
        window.location.href = '${pageContext.request.contextPath}/';
    }

    function redirectToMain() {
        window.location.href = '${pageContext.request.contextPath}/';
    }
</script>

</body>
</html>
