package com.task.questions.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;



@Entity(name = "question")
public class Question {

    @Id
    @Column(name = "question_id")
    private UUID question_id;

    @Column(name = "question_text")
    @NotBlank
    private String question_text;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="question")
    private Set<Answer> answers;

    public Question(@JsonProperty("question_id") UUID question_id,
                    @JsonProperty("question") String question_text) {
        this.question_id = question_id;
        this.question_text = question_text;
    }

    public Question() {
    }

    public UUID getQuestion_id() {
        return question_id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    public void setQuestion_id(UUID question_id) {
        this.question_id = question_id;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }
}
