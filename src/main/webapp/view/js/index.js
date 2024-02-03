function redirectToCreateMatch() {
    window.location.href = '${pageContext.request.contextPath}/new-match';
}

function redirectToCompletedMatchesPage() {
    window.location.href = '${pageContext.request.contextPath}/completed-matches';
}