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
                        <span>${requestScope.ongoingMatch.getMatchScore().getGame().getFirstPlayerScore().getValue()}</span>
                    </div>
                    <div class="first-set">
                        <c:if test="${ongoingMatch.matchScore.sets[0] ne null}">
                            ${ongoingMatch.matchScore.sets[0].firstPlayerScore.getValue()}
                        </c:if>
                    </div>
                    <div class="first-set">
                        <c:if test="${ongoingMatch.matchScore.sets[1] ne null}">
                            ${ongoingMatch.matchScore.sets[1].firstPlayerScore.getValue()}
                        </c:if>
                    </div>
                    <div class="first-set">
                        <c:if test="${ongoingMatch.matchScore.sets[2] ne null}">
                            ${ongoingMatch.matchScore.sets[2].firstPlayerScore.getValue()}
                        </c:if>
                    </div>
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
                        <span>${ongoingMatch.getMatchScore().getGame().getSecondPlayerScore().getValue()}</span>
                    </div>
                    <div class="first-set">
                        <c:if test="${ongoingMatch.matchScore.sets[0] ne null}">
                            ${ongoingMatch.matchScore.sets[0].secondPlayerScore.getValue()}
                        </c:if>
                    </div>
                    <div class="first-set">
                        <c:if test="${ongoingMatch.matchScore.sets[1] ne null}">
                            ${ongoingMatch.matchScore.sets[1].secondPlayerScore.getValue()}
                        </c:if>
                    </div>
                    <div class="first-set">
                        <c:if test="${ongoingMatch.matchScore.sets[2] ne null}">
                            ${ongoingMatch.matchScore.sets[2].secondPlayerScore.getValue()}
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="button-container">
                <button class="button-game" name="value" value="true">POINT FOR PLAYER 1</button>
                <button class="button-game" onclick="redirectToCompletedMatchesPage()">CONTINUE</button>
                <button class="button-game" name="value" value="false">POINT FOR PLAYER 2</button>
            </div>
        </div>
        <div class="matchId-container">
            <h6>MATCH ID : ${ongoingMatch.getId()} </h6>
        </div>
    </div>
</div>
<script>
    function redirectToCompletedMatchesPage() {
        window.location.href = '${pageContext.request.contextPath}/completed-matches';
    }

    // Отримуємо елементи, які будемо оновлювати
    const scoreElement = document.getElementById('score-value');

    // Функція для оновлення даних на сторінці
    const updateData = (score) => {
        scoreElement.textContent = score;
    };

    // Функція для виклику AJAX-запиту
    const makeAjaxRequest = (value) => {
        // Ваш код для виклику AJAX-запиту
        // Використовуйте, наприклад, fetch або XMLHttpRequest
        // Приклад:
        fetch(`/your-api-endpoint?value=${value}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            // Додайте тіло запиту, якщо потрібно
            // body: JSON.stringify({}),
        })
            .then(response => response.json())
            .then(data => {
                // Після успішного отримання відповіді, оновіть дані на сторінці
                updateData(data.score);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    };

    // Додаємо обробник подій для кожної кнопки
    document.getElementById('player1-button').addEventListener('click', () => {
        makeAjaxRequest(true);
    });

    document.getElementById('player2-button').addEventListener('click', () => {
        makeAjaxRequest(false);
    });
</script>


</body>
</html>
