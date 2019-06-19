package com.emusicstore.dao.impl;

import com.emusicstore.dao.UserDao;
import com.emusicstore.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory; //singleton pattern

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        session.flush();

    }

    public User getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        session.flush();
        return user;
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User");
        List<User> users = query.list();
        session.flush();
        return users;
    }

    public void deleteUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getUserById(id));
        session.flush();
    }
}
