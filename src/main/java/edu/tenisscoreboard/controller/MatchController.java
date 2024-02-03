package edu.tenisscoreboard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.tenisscoreboard.controller.dto.MatchDTO;
import edu.tenisscoreboard.domain.Player;
import edu.tenisscoreboard.mapper.MatchMapper;
import edu.tenisscoreboard.service.MatchService;
import edu.tenisscoreboard.service.PlayerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(value = "/all")
@Slf4j
public class MatchController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
