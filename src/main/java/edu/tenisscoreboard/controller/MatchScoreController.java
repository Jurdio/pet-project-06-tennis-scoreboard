package edu.tenisscoreboard.controller;

import edu.tenisscoreboard.domain.OngoingMatch;
import edu.tenisscoreboard.service.MatchScoreCalculationService;
import edu.tenisscoreboard.service.OngoingMatchService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/match-score")
@Slf4j
public class MatchScoreController extends HttpServlet {
    private final OngoingMatchService ongoingMatchService = OngoingMatchService.getInstance();
    private final MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OngoingMatch ongoingMatch = ongoingMatchService.getMatch(UUID.fromString(req.getParameter("uuid")));
        log.debug("Score :{}",ongoingMatch.getMatchSc().getGame().getFirstPlayerScore());
        req.setAttribute("ongoingMatch", ongoingMatch);
        req.getRequestDispatcher("/view/match-score.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        String value = req.getParameter("value");
        log.debug("{}", value);
        matchScoreCalculationService.addPoint(uuid,value);



        resp.sendRedirect("match-score?uuid=" + uuid);
    }
}
