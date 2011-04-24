package org.questions.dao;

import org.hibernate.Query;
import org.questions.domain.AppUser;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: naim
 * Date: Jun 29, 2010
 */
@SuppressWarnings("unchecked")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
    public AppUser get(Long id) {
        return getHibernateTemplate().get(AppUser.class, id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Long save(AppUser user) {
        getHibernateTemplate().saveOrUpdate(user);
        getHibernateTemplate().flush();
        return user.getId();        
    }

    public List<AppUser> list() {
        return getHibernateTemplate().find("FROM AppUser u ORDER BY lower(u.name)");
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(int id) {
    }

    public AppUser get(String email, String password) {
        List<AppUser> lst = getSession().createQuery("FROM AppUser u WHERE u.email = :email AND u.password = :password")
                .setString("email", email)
                .setString("password", password)
                .list();
        if (lst.size() > 0) {
            return lst.get(0);
        } else {
            return null;
        }
    }

    public AppUser getUserByPhoneNumber(String phoneNumber) {
        List<AppUser> users = getHibernateTemplate().findByNamedParam(
                "FROM AppUser q WHERE q.phoneNumber like :pn", "pn", "%" + phoneNumber.trim());

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public AppUser getUserByEmailId(String emailId) {
        List<AppUser> users = getHibernateTemplate().findByNamedParam(
                "FROM AppUser q WHERE q.emailId like :em", "em", emailId.trim());

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }


    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void increamentNumberOfQuestionAnswered(Long userId) {
        Query q = getSession().createQuery("UPDATE AppUser SET numberOfQuestionAnswered = (numberOfQuestionAnswered + 1)"
                + "WHERE id = :userId");
        q.setLong("userId", userId);
        q.executeUpdate();
    }

    public List<AppUser> getTopAnswerCount() {
//        return getHibernateTemplate().find("FROM AppUser u ORDER BY u.numberOfQuestionAnswered DESC");
        Query q = getSession().createQuery("FROM AppUser u ORDER BY u.numberOfQuestionAnswered DESC");
        q.setMaxResults(10);
        return q.list();
    }
}
