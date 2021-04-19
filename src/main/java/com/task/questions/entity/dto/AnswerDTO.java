package com.task.questions.entity.dto;

import com.task.questions.entity.Question;

import java.util.UUID;


public class AnswerDTO {
    private  UUID answer_id;

    private  String answer_text;

    private Question question;

    public UUID getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(UUID answer_id) {
        this.answer_id = answer_id;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
