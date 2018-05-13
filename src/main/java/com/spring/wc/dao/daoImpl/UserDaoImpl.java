package com.spring.wc.dao.daoImpl;

import com.spring.wc.dao.UserDao;
import com.spring.wc.model.User;
import com.spring.wc.util.SHA;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public User login(User user) {
        Session session=sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", user.getUsername()));
        criteria.add(Restrictions.eq("password", SHA.getKey(user.getPassword())));
        User result = (User)criteria.uniqueResult();
        session.close();
        return result;
    }

    @Override
    @Transactional
    public void logout(User user) {

    }
}
