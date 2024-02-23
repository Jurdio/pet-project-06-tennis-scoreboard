package edu.tenisscoreboard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tenisscoreboard.service.FinishedMatchesPersistenceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


@WebServlet(value = "/matches")
@Slf4j
public class MatchesController extends HttpServlet {
    private final FinishedMatchesPersistenceService finishedMatchesPersistenceService = new FinishedMatchesPersistenceService();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filterName = req.getParameter("filter_by_player_name");
        int page = req.getParameter("page") == null ? 0 : Integer.parseInt(req.getParameter("page"));
        int pageSize = 5;
        int totalItems = 0;



    }
}
