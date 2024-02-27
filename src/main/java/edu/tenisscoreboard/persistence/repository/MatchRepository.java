package edu.tenisscoreboard.persistence.repository;

import edu.tenisscoreboard.persistence.entity.MatchEntity;
import edu.tenisscoreboard.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class MatchRepository implements CrudRepository<MatchEntity> {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Optional<MatchEntity> findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(MatchEntity.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<MatchEntity> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM MatchEntity", MatchEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public MatchEntity save(MatchEntity entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return entity;
    }

    @Override
    public void update(MatchEntity entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            MatchEntity entityToDelete = session.get(MatchEntity.class, id);
            if (entityToDelete != null) {
                session.delete(entityToDelete);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public List<MatchEntity> findWithPagination(int offset, int pageSize) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM MatchEntity", MatchEntity.class)
                    .setFirstResult(offset)
                    .setMaxResults(pageSize)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public List<MatchEntity> findMatchesWithPaginationByPlayerName(String name, int offset, int pageSize) {
        try (Session session = sessionFactory.openSession()) {
            // Ваш SQL-запит для пошуку матчів з пагінацією за ім'ям гравця
            String sql = "SELECT m FROM MatchEntity m " +
                    "WHERE m.firstPlayer.name = :playerName OR m.secondPlayer.name = :playerName " +
                    "ORDER BY m.id";

            return session.createQuery(sql, MatchEntity.class)
                    .setParameter("playerName", name)
                    .setFirstResult(offset)
                    .setMaxResults(pageSize)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
