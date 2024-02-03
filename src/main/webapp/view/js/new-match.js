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