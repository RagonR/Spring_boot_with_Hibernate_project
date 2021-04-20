package com.task.questions.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity(name = "answer")
public class Answer {

    @Id
    @Column(name = "answer_id")
    private UUID answer_id;

    @Column(name = "answer_text")
    @NotBlank
    private String answer_text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id", nullable=false)
    private Question question;


    public Answer(@JsonProperty("answer_id") UUID answer_id,
                  @JsonProperty("answer_text") String answer_text,
                  @JsonProperty("question_id") Question question) {
        this.answer_id = answer_id;
        this.answer_text = answer_text;
        this.question = question;
    }

    public Answer() {
    }

    @JsonIgnore
    public UUID getAnswer_id() {
        return answer_id;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    @JsonIgnore
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setAnswer_id(UUID answer_id) {
        this.answer_id = answer_id;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }
}
