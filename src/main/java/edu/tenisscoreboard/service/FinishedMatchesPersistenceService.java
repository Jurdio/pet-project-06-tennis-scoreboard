package edu.tenisscoreboard.service;

import edu.tenisscoreboard.domain.Match;
import edu.tenisscoreboard.mapper.MatchMapper;
import edu.tenisscoreboard.persistence.entity.MatchEntity;
import edu.tenisscoreboard.persistence.repository.MatchRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FinishedMatchesPersistenceService {
    private final MatchRepository matchRepository = new MatchRepository();
    private final MatchMapper matchMapper = Mappers.getMapper(MatchMapper.class);

    public void saveMatch(Match match) {
        matchRepository.save(matchMapper.toMatchEntity(match));
    }

    public Match getMatchById(int id) {
        return matchMapper.toMatch(matchRepository.findById(id).orElseThrow());
    }

    public List<Match> getAllMatches() {
        List<MatchEntity> matchEntities = matchRepository.findAll();
        log.debug("List of entity {}:", matchEntities);

        return matchEntities.stream()
                .map(matchMapper::toMatch)
                .collect(Collectors.toList());
    }

    public List<Match> getMatchesWithPagination(int currentPage, int pageSize) {
        int offset = (currentPage - 1) * pageSize;
        List<MatchEntity> matchEntities = matchRepository.findWithPagination(offset, pageSize);

        return matchEntities.stream()
                .map(matchMapper::toMatch)
                .collect(Collectors.toList());
    }

    public List<Match> getMatchesWithPaginationByPlayerName(String name, int currentPage, int pageSize) {
        int offset = (currentPage - 1) * pageSize;
        List<MatchEntity> matchEntities = matchRepository.findMatchesWithPaginationByPlayerName(name, offset, pageSize);

        return matchEntities.stream()
                .map(matchMapper::toMatch)
                .collect(Collectors.toList());
    }
}
