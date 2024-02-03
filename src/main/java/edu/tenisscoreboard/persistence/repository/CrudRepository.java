package edu.tenisscoreboard.persistence.repository;

import edu.tenisscoreboard.persistence.entity.MatchEntity;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    Optional<T> findById(int id);
    List<T> findAll();
    T save(T entity);
    void update(T entity);
    void delete(int id);
}
