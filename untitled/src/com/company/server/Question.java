package com.company.server;

//import com.company.client.random.Generate;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Question {
    private String question;
    private final UUID uuid = UUID.randomUUID();
    private final String id= String.valueOf(uuid);
    private String answer;

    public Question() {
    }

    public Question(String question,  String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getId() {
        return id;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
