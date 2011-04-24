package org.questions.dao;

import org.questions.ctlr.SearchCmd;
import org.questions.domain.Answer;
import org.questions.domain.Question;

import java.util.List;

/**
 * mdnhuda@gmail.com
 * Date: Jul 2, 2010
 */
public interface QuestionDao {
    Question getQuestion(Long id);
    Long save(Question question);
    void update(Question question);
    void delete(Long id);
    List<Question> search(SearchCmd cmd);

    Long save(Answer answer);
}
