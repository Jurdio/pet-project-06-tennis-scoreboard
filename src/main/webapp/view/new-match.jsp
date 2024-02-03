<%--
  Created by IntelliJ IDEA.
  User: Dmytro
  Date: 29.01.2024
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tennis board</title>
</head>
<body>
<div>
    <div class="header">
        <h1>NEW MATCH</h1>
    </div>
    <div>
        <form action="${pageContext.request.contextPath}/new-match" method="post" onsubmit="return validateForm()" accept-charset="UTF-8">
            <label for="player1">Player 1:</label>
            <input type="text" name="player1" id="player1"><br>
            <label for="player2">Player 2:</label>
            <input type="text" name="player2" id="player2"><br>
            <input type="submit" value="Start">
        </form>
        <script>
            function validateForm() {
                const input1 = document.getElementById("player1").value;
                if (input1 === "") {
                    alert("Input name for first player");
                    return false;
                }
                const input2 = document.getElementById("player2").value;
                if (input2 === "") {
                    alert("Input name for second player");
                    return false;
                }
            }
        </script>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/">Return to main page</a>
    </div>
</div>

</body>
</html>
