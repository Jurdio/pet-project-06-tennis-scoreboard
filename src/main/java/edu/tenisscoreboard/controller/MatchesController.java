package edu.tenisscoreboard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class MatchesController extends HttpServlet {
    private final FinishedMatchesPersistenceService finishedMatchesPersistenceService = new FinishedMatchesPersistenceService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filterName = req.getParameter("filter_by_player_name");
        int page = req.getParameter("page") == null ? 1 : Integer.parseInt(req.getParameter("page"));
        int pageSize = 5;

        // Отримати кількість всіх матчів (без пагінації) для визначення загальної кількості сторінок
        int totalMatches = finishedMatchesPersistenceService.getAllMatches().size();

        // Визначити загальну кількість сторінок
        int totalPages = (int) Math.ceil((double) totalMatches / pageSize);

        // Встановити правильний offset в залежності від обраної сторінки
        int offset = (page - 1) * pageSize;

        // Отримати список матчів від сервісу, враховуючи фільтрацію та пагінацію
        List<Match> listOfMatches = List.of();
        if (filterName != null && !filterName.isEmpty()) {
            listOfMatches = finishedMatchesPersistenceService.getMatchesWithPaginationByPlayerName(filterName, offset, pageSize);
        } else {
            listOfMatches = finishedMatchesPersistenceService.getMatchesWithPagination(offset, pageSize);
        }

        // Передати список матчів, кількість сторінок і поточну сторінку як атрибути для виведення в JSP
        req.setAttribute("listOfMatches", listOfMatches);
        req.setAttribute("totalPages", totalPages);
        req.setAttribute("currentPage", page);

        // Перенаправлення на JSP-сторінку
        req.getRequestDispatcher("/view/completed-matches.jsp").forward(req, resp);
    }
    }

