package edu.tenisscoreboard.mapper;

import edu.tenisscoreboard.controller.dto.MatchDTO;
import edu.tenisscoreboard.domain.Match;
import edu.tenisscoreboard.persistence.entity.MatchEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MatchMapper {
    Match toMatch (MatchDTO matchDTO);
    MatchDTO toMatchDTO (Match match);
    Match toMatch (MatchEntity matchEntity);
    MatchEntity toMatchEntity (Match match);
}
