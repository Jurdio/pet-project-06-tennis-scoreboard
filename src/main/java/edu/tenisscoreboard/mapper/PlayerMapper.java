package edu.tenisscoreboard.mapper;

import edu.tenisscoreboard.controller.dto.MatchDTO;
import edu.tenisscoreboard.domain.Match;
import edu.tenisscoreboard.domain.Player;

import edu.tenisscoreboard.persistence.entity.PlayerEntity;
import org.mapstruct.Mapper;

@Mapper
public interface PlayerMapper {
    Player toPlayer (PlayerEntity playerEntity);
    PlayerEntity toPlayerEntity (Player player);
}
