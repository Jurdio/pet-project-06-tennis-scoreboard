package edu.tenisscoreboard.persistence.repository;

import edu.tenisscoreboard.persistence.entity.PlayerEntity;
import edu.tenisscoreboard.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class PlayerRepository implements CrudRepository<PlayerEntity> {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Optional<PlayerEntity> findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(PlayerEntity.class, id));
        }
    }

    public Optional<PlayerEntity> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM PlayerEntity WHERE name = :playerName";
            Query<PlayerEntity> query = session.createQuery(hql, PlayerEntity.class);
            query.setParameter("playerName", name);

            PlayerEntity player = query.uniqueResult();
            return Optional.ofNullable(player);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<PlayerEntity> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM PlayerEntity ", PlayerEntity.class).list();
        }
    }

    @Override
    public PlayerEntity save(PlayerEntity entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
        return entity;
    }

    @Override
    public void update(PlayerEntity entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
    }

    @Override
    public void delete(int id) {

    }
}
