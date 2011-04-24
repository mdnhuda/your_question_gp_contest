package org.questions.dao;

import org.questions.domain.AppUser;

import java.util.List;

/**
 * User: naim
 * Date: Jun 29, 2010
 */
public interface UserDao {
    AppUser get(Long id);
    Long save(AppUser user);
    List<AppUser> list();
    AppUser getUserByEmailId(String email);
    AppUser getUserByPhoneNumber(String phoneNumber);
    void delete(int id);
    AppUser get(String email, String password);
    public void increamentNumberOfQuestionAnswered(Long userId);
    public List<AppUser> getTopAnswerCount();

}
