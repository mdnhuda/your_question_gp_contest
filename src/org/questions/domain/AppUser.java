package org.questions.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * User: naim
 * Date: Jun 29, 2010
 */
@Entity
@Table(name = "user")
public class AppUser extends Persistent {
    private Long id;
    private String name;
    private String email;

    private String userId;
    private String password;

    private String password2;

    private String address;
    private Date dob;
    private String phoneNumber;
    private String specialization;
    private String note;
    private int numberOfQuestionAnswered;

    public AppUser() {
    }
    
    public AppUser(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(unique = true, nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(unique = true, nullable = false, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Column(unique = true, nullable = true, length = 11)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Column(length = 50)
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Column(length = 100)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getNumberOfQuestionAnswered() {
        return numberOfQuestionAnswered;
    }

    public void setNumberOfQuestionAnswered(int numberOfQuestionAnswered) {
        this.numberOfQuestionAnswered = numberOfQuestionAnswered;
    }

    @Transient
    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
