package com.task.questions.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.task.questions.entity.Answer;

import java.util.Set;
import java.util.UUID;


public class QuestionDTO {
    private UUID question_id;

    private String question_text;

    private Set<Answer> answers;

    public UUID getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(UUID question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
}
