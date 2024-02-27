package edu.tenisscoreboard.controller;

import edu.tenisscoreboard.domain.Match;
import edu.tenisscoreboard.service.FinishedMatchesPersistenceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/completed-matches")
@Slf4j
public class CompletedMatchesController extends HttpServlet {

    private final FinishedMatchesPersistenceService finishedMatchesPersistenceService = new FinishedMatchesPersistenceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filterName = req.getParameter("filter_by_player_name");
        int currentPage = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
        int pageSize = 10;
        int totalMatches = finishedMatchesPersistenceService.getAllMatches().size();
        int totalPages = (int) Math.ceil((double) totalMatches / pageSize);

        List<Match> listOfMatches;

        if (filterName != null && !filterName.isEmpty()) {
            listOfMatches = finishedMatchesPersistenceService.getMatchesWithPaginationByPlayerName(filterName, currentPage, pageSize);
        } else {
            listOfMatches = finishedMatchesPersistenceService.getMatchesWithPagination(currentPage, pageSize);
        }

        req.setAttribute("listOfMatches", listOfMatches);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", currentPage);

        req.getRequestDispatcher("/view/completed-matches.jsp").forward(req, resp);
    }
}

