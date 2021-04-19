package com.task.questions.service.mapper;

import com.task.questions.entity.Answer;
import com.task.questions.entity.Question;
import com.task.questions.entity.dto.AnswerDTO;
import com.task.questions.entity.dto.QuestionDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EntityMapper {

    public QuestionDTO convertQuestionEntityToDTO(Question question, UUID question_id) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setQuestion_id(question.getQuestion_id());
        questionDTO.setQuestion_text(question.getQuestion_text());
        questionDTO.setAnswers(question.getAnswers());
        return questionDTO;
    }

    public QuestionDTO convertQuestionEntityToDTO(Question question) {
        return convertQuestionEntityToDTO(question, question.getQuestion_id());
    }

    public AnswerDTO convertAnswerEntityToDTO(Answer answer, UUID answer_id) {
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setAnswer_id(answer.getAnswer_id());
        answerDTO.setAnswer_text(answer.getAnswer_text());
        answerDTO.setQuestion(answer.getQuestion());
        return answerDTO;
    }

    public AnswerDTO convertAnswerEntityToDTO(Answer answer) {
        return convertAnswerEntityToDTO(answer, answer.getAnswer_id());
    }

}
