package org.questions.dao;

import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.util.Version;
import org.hibernate.Query;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.questions.ctlr.SearchCmd;
import org.questions.domain.Answer;
import org.questions.domain.Question;
import org.questions.domain.Status;
import org.questions.utils.Globals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * mdnhuda@gmail.com
 * Date: Jul 2, 2010
 */
@SuppressWarnings("unchecked")
public class QuestionDaoImpl extends HibernateDaoSupport implements QuestionDao {
    Logger logger = LoggerFactory.getLogger(getClass());

    public Question getQuestion(Long id) {
        return getHibernateTemplate().get(Question.class, id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Long save(Question q) {
        if (q.getId() != null && q.getId() > 0) {
            getHibernateTemplate().update(q);
            return q.getId();
        } else {
            return (Long) getHibernateTemplate().save(q);
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void update(Question q) {
        getHibernateTemplate().update(q);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        Question q = getHibernateTemplate().get(Question.class, id);
        q.setStatus(Status.DELETED);
        getHibernateTemplate().update(q);
    }

    public List<Question> search(SearchCmd cmd) {
        org.hibernate.Query hibQuery = createQuery(cmd);
        hibQuery.setFirstResult((cmd.getPageNumber() -1) * Globals.NUMBER_OF_ENTRIES_PER_PAGE);
        hibQuery.setMaxResults(Globals.NUMBER_OF_ENTRIES_PER_PAGE);
        return hibQuery.list();
    }

    private org.hibernate.Query createQuery(SearchCmd searchCmd) {
        org.hibernate.Query hibQuery = null;
        if (!Globals.isEmpty(searchCmd.getQueryStr())) {
            String[] productFields =
                    new String[] {"category", "category_stem", "text", "text_stem", "answers.text", "answers.text_stem"};
            FullTextSession fullTextSession = Search.getFullTextSession(getSession());

            QueryParser parser = new MultiFieldQueryParser(Version.LUCENE_29, productFields,
                    fullTextSession.getSearchFactory().getAnalyzer(Question.class));
            org.apache.lucene.search.Query luceneQuery;
            try {
                luceneQuery = parser.parse(searchCmd.getQueryStr());
            } catch (ParseException e) {
                logger.error("Lucene Query Parse error!", e);
                throw new RuntimeException("Lucene Query Parse error! query=" + searchCmd.getQueryStr(), e);
            }

            hibQuery = fullTextSession.createFullTextQuery(luceneQuery, Question.class);
        } else if (!Globals.isEmpty(searchCmd.getCategory())) {
            hibQuery = getSession().createQuery("FROM Question q WHERE q.category like :category ORDER BY q.dateCreated DESC");
            hibQuery.setString("category", searchCmd.getCategory());
        } else if (searchCmd.isUnanswered()) {
            hibQuery = getSession().createQuery("FROM Question q WHERE q.status = :status ORDER BY q.dateCreated DESC");
            hibQuery.setParameter("status", Status.PENDING);
        } else if (searchCmd.isAnswered()) {
            hibQuery = getSession().createQuery("FROM Question q WHERE q.status = :status ORDER BY q.dateCreated DESC");
            hibQuery.setParameter("status", Status.ANSWERED);
        } else if (searchCmd.getUser() != null && searchCmd.isQuestionedByMe()) {
            hibQuery = getSession().createQuery("FROM Question q WHERE q.createdBy = :createdBy ORDER BY q.dateCreated DESC");
            hibQuery.setEntity("createdBy", searchCmd.getUser());
        }
//        else if (searchCmd.getUser() != null && searchCmd.isAnsweredByMe()) {
//            hibQuery = getSession().createQuery("FROM Question q JOIN Answer a WHERE a.createdBy = :createdBy ORDER BY q.dateCreated");
//            hibQuery.setEntity("createdBy", searchCmd.getUser());
//        }
        else {
            hibQuery = getSession().createQuery("FROM Question q ORDER BY q.dateCreated DESC");            
        }
        return hibQuery;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Long save(Answer answer) {
        Long id = (Long) getHibernateTemplate().save(answer);
        logger.debug("Answer Saved with id={}", id);
        return id;
    }

    
}
