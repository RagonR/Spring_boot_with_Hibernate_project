package com.task.questions.service.mapper;

import com.task.questions.entity.Answer;
import com.task.questions.entity.Question;
import com.task.questions.entity.dto.AnswerDTO;
import com.task.questions.entity.dto.QuestionDTO;
import com.task.questions.repository.AnswerRepository;
import com.task.questions.repository.QuestionRepository;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;

@Component
public class DtoMapper {

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;


    public DtoMapper(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public Question convertQuestionDtoToEntity(QuestionDTO questionDTO) {
        Question question = new Question();
        question.setQuestion_id(questionDTO.getQuestion_id());
        question.setQuestion_text(questionDTO.getQuestion_text());
        question.setAnswers(questionDTO.getAnswers());
        return question;
    }

    public Answer convertAnswerDtoToEntity(AnswerDTO answerDTO) {
        Answer answer = new Answer();
        Question question = questionRepository.getOne(answerDTO.getQuestion().getQuestion_id());
        answer.setAnswer_id(answerDTO.getAnswer_id());
        answer.setQuestion(question);
        answer.setAnswer_text(answerDTO.getAnswer_text());
        return answer;
    }
}
