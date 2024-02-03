package edu.tenisscoreboard.service;

import edu.tenisscoreboard.domain.Match;
import edu.tenisscoreboard.domain.Player;
import edu.tenisscoreboard.mapper.MatchMapper;
import edu.tenisscoreboard.mapper.PlayerMapper;
import edu.tenisscoreboard.persistence.entity.MatchEntity;
import edu.tenisscoreboard.persistence.entity.PlayerEntity;
import edu.tenisscoreboard.persistence.repository.MatchRepository;
import edu.tenisscoreboard.persistence.repository.PlayerRepository;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerService {
    private final PlayerRepository playerRepository = new PlayerRepository();
    private final PlayerMapper playerMapper = Mappers.getMapper(PlayerMapper.class);

    public Player findOrCreatePlayer(String name){
        PlayerEntity entity = playerRepository.findByName(name)
                .orElseGet(() -> playerRepository.save(PlayerEntity.builder().name(name).build()));

        Player player = playerMapper.toPlayer(entity);

        // Add logging statements here to trace values
        return player;
    }
}
