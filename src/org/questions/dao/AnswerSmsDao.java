package org.questions.dao;

import org.questions.domain.AnswerSms;

import java.util.List;

/**
 * mdnhuda@gmail.com
 * Date: Jul 3, 2010
 */
public interface AnswerSmsDao {
    List<AnswerSms> getPending();
    void save(AnswerSms as);
    void setSent(Long id);
}
