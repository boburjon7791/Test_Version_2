package com.company.server;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UserTestSolveHistory {
    private User user;
    private Subject subject;
    private int ball;
    private final LocalDateTime date= LocalDateTime.now();


    public UserTestSolveHistory() {
    }

    public UserTestSolveHistory(User user, Subject subject, int ball) {
        this.user = user;
        this.subject = subject;
        this.ball = ball;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public int getBall() {
        return ball;
    }
    public void setBall(int ball){
        this.ball = ball;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubject() {
        return subject.getName();
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "UserTestSolveHistory{" +
                "user=" + user +
                ", subject=" + subject +
                ", ball=" + ball +
                '}';
    }
}
