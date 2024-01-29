package edu.tenisscoreboard.mapper;

import edu.tenisscoreboard.controller.dto.MatchDTO;
import edu.tenisscoreboard.domain.Match;
import org.mapstruct.Mapper;

@Mapper
public interface MatchMapper {
    Match toMatch (MatchDTO matchDTO);
    MatchDTO toMatchDTO (Match match);
}
