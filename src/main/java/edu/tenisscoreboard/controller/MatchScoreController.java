package edu.tenisscoreboard.controller;

import edu.tenisscoreboard.domain.OngoingMatch;
import edu.tenisscoreboard.service.OngoingMatchService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(value = "/match-score")
public class MatchScoreController extends HttpServlet {
    private final OngoingMatchService ongoingMatchService = OngoingMatchService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OngoingMatch ongoingMatch = ongoingMatchService.getMatch(UUID.fromString(req.getParameter("uuid")));
        req.setAttribute("OngoingMatch", ongoingMatch);
        req.getRequestDispatcher("/view/match-score.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
