package com.task.questions.service.dao;

import com.task.questions.entity.dto.AnswerDTO;

import java.util.List;
import java.util.UUID;

public interface AnswerService {

    List<AnswerDTO> getAllAnswer();

    AnswerDTO getSingleAnswerById(UUID answer_id);

    AnswerDTO createAnswer(AnswerDTO answerDTO);

    AnswerDTO updateAnswer(AnswerDTO answerDTO);

    void deleteAnswer(UUID id);
}
