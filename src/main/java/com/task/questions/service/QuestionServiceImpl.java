package com.task.questions.service;

import com.task.questions.entity.Question;
import com.task.questions.entity.dto.QuestionDTO;
import com.task.questions.repository.QuestionRepository;
import com.task.questions.service.dao.QuestionService;
import com.task.questions.service.mapper.DtoMapper;
import com.task.questions.service.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;
    private EntityMapper entityMapper;
    private DtoMapper dtoMapper;

    public QuestionServiceImpl(QuestionRepository questionRepository, EntityMapper entityMapper, DtoMapper dtoMapper) {
        this.questionRepository = questionRepository;
        this.entityMapper = entityMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<QuestionDTO> getAllQuestions() {
        return questionRepository.findAll()
                .stream()
                .map(question -> entityMapper.convertQuestionEntityToDTO(question))
                .collect(Collectors.toList());
    }

    @Override
    public QuestionDTO getSingleQuestionById(UUID question_id) {
        if (question_id == null) {
            throw new EntityNotFoundException(question_id.toString());
        }
        return entityMapper.convertQuestionEntityToDTO(questionRepository.getOne(question_id));
    }

    @Override
    public QuestionDTO createQuestion(QuestionDTO questionDTO) {
        Question question = dtoMapper.convertQuestionDtoToEntity(questionDTO);
        Question savedQuestion = questionRepository.save(question);
        return entityMapper.convertQuestionEntityToDTO(savedQuestion);
    }

    @Override
    public QuestionDTO updateQuestion(QuestionDTO questionDTO) {
        UUID id = questionDTO.getQuestion_id();
        if (questionRepository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(id.toString());
        }
        Question question = dtoMapper.convertQuestionDtoToEntity(questionDTO);
        Question updatedQuestion = questionRepository.save(question);
        return entityMapper.convertQuestionEntityToDTO(updatedQuestion);
    }

    @Override
    public void deleteQuestion(UUID id) {
        if (!questionRepository.existsById(id)) {
            throw new EntityNotFoundException(id.toString());
        }
        questionRepository.deleteById(id);
    }

}
