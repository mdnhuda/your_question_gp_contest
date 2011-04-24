package org.questions.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.questions.domain.AnswerSms;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * mdnhuda@gmail.com
 * Date: Jul 3, 2010
 */

@SuppressWarnings("unchecked")
public class AnswerSmsDaoImpl extends HibernateDaoSupport implements AnswerSmsDao {
    public List<AnswerSms> getPending() {
        Session session = getSession();
        Query q = session.createQuery("FROM AnswerSms a WHERE a.sent = false ORDER BY a.dateCreated desc");
        return q.list();
    }

    public void save(AnswerSms as) {
        getHibernateTemplate().saveOrUpdate(as);
    }

    public void setSent(Long id) {
        Query q = getSession().createQuery("UPDATE AnswerSms SET sent = true WHERE id = :id");
        q.setLong("id", id);
        q.executeUpdate();
    }
}
