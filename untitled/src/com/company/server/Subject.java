package com.company.server;

import com.company.server.database.Database;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private double totalBall=0;
    private final List<Question> subjectQuestions = new ArrayList<>();

    public Subject() {
    }

    public double getTotalBall() {
        return totalBall;
    }



    public void setTotalBall(double totalBall) {
        this.totalBall += totalBall;
    }

    public Subject(String name) {
        this.name = name;
    }
    public void addQuestion(Question question){
        this.subjectQuestions.add(question);
    }
    public void removeQuestion(Question question){
        Database.DELETED.add(question);
        this.subjectQuestions.remove(question);
    }
    public List<Question> getSubjectQuestions() {
        return subjectQuestions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Subject[" +
                "name='" + name + '\'' +
                ']';
    }
}
