package edu.tenisscoreboard.controller;

import edu.tenisscoreboard.domain.OngoingMatch;
import edu.tenisscoreboard.mapper.MatchMapper;
import edu.tenisscoreboard.service.MatchService;
import edu.tenisscoreboard.service.OngoingMatchService;
import edu.tenisscoreboard.service.PlayerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

import java.io.IOException;

@WebServlet(name = "NewMatchServlet", value = "/new-match")
@Slf4j
public class NewMatchController extends HttpServlet {
    private MatchService matchService;
    private PlayerService playerService;
    private MatchMapper matchMapper;

    @Override
    public void init() throws ServletException {
        matchService = new MatchService();
        playerService = new PlayerService();
        matchMapper = Mappers.getMapper(MatchMapper.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/new-match.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstPlayerName = req.getParameter("player1").toUpperCase();
        String secondPlayerName = req.getParameter("player2").toUpperCase();

        resp.sendRedirect("match-score?uuid=" + OngoingMatchService.getInstance()
                .createMatch(playerService.findOrCreatePlayer(firstPlayerName),playerService.findOrCreatePlayer(secondPlayerName)));
    }
}
