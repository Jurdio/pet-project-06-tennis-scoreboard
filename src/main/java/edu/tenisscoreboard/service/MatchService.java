package edu.tenisscoreboard.service;

import edu.tenisscoreboard.domain.Match;
import edu.tenisscoreboard.mapper.MatchMapper;
import edu.tenisscoreboard.persistence.entity.MatchEntity;
import edu.tenisscoreboard.persistence.repository.MatchRepository;
import edu.tenisscoreboard.persistence.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class MatchService {
    private final MatchRepository matchRepository = new MatchRepository();
    private final MatchMapper matchMapper = Mappers.getMapper(MatchMapper.class);

    public List<Match> getAllMatches(){

        List<MatchEntity> matchEntities = matchRepository.findAll();
        log.debug("List of entity {}:",matchEntities);

        return matchEntities.stream()
                .map(matchMapper::toMatch)
                .collect(Collectors.toList());
    }

    public Match getMatchById(int id){
        return matchMapper.toMatch(matchRepository.findById(id).orElseThrow());
    }

    public Match saveMatch(Match match) {
        MatchEntity savedEntity = matchRepository.save(matchMapper.toMatchEntity(match));

        return matchMapper.toMatch(savedEntity);
    }


}
