package org.questions.ctlr;

import org.questions.domain.AppUser;

import java.io.Serializable;

/**
 * mdnhuda@gmail.com
 * Date: Jul 10, 2010
 */
public class SearchCmd implements Serializable {
    private int pageNumber = 1;

    //Raw Search (lucene)
    private String queryStr;

    // Predefined Search
    private boolean unanswered;
    private boolean answered;
    private boolean answeredByMe;
    private boolean questionedByMe;
    private String category;

    private AppUser user;
        
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getQueryStr() {
        return queryStr;
    }

    public void setQueryStr(String queryStr) {
        this.queryStr = queryStr;
    }

    public boolean isUnanswered() {
        return unanswered;
    }

    public void setUnanswered(boolean unanswered) {
        this.unanswered = unanswered;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public boolean isAnsweredByMe() {
        return answeredByMe;
    }

    public void setAnsweredByMe(boolean answeredByMe) {
        this.answeredByMe = answeredByMe;
    }

    public boolean isQuestionedByMe() {
        return questionedByMe;
    }

    public void setQuestionedByMe(boolean questionedByMe) {
        this.questionedByMe = questionedByMe;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}
