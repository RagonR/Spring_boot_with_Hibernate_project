package com.task.questions.service.dao;

import com.task.questions.entity.dto.QuestionDTO;

import java.util.List;
import java.util.UUID;

public interface QuestionService {

    List<QuestionDTO> getAllQuestions();

    QuestionDTO getSingleQuestionById(UUID question_id);

    QuestionDTO createQuestion(QuestionDTO questionDTO);

    QuestionDTO updateQuestion(QuestionDTO questionDTO);

    void deleteQuestion(UUID id);
}
