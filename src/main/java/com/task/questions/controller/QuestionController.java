package com.task.questions.controller;


import com.task.questions.entity.dto.QuestionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.task.questions.service.QuestionServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/question")
public class QuestionController {

    private final QuestionServiceImpl questionServiceImp;
//    @Autowired
    public QuestionController(QuestionServiceImpl questionServiceImp) {
        this.questionServiceImp = questionServiceImp;
    }

    @GetMapping
    public List<QuestionDTO> getAllQuestions() {
        return questionServiceImp.getAllQuestions();
    }

    @GetMapping("/{id}")
    public QuestionDTO getSingleQuestionById(@PathVariable UUID id) {
        return questionServiceImp.getSingleQuestionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionDTO saveQuestion(@RequestBody @Valid QuestionDTO questionDTO) {
        return questionServiceImp.createQuestion(questionDTO);
    }

    @PutMapping("edit/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public QuestionDTO updatePost(@RequestBody @Valid QuestionDTO questionDTO) {
        return questionServiceImp.updateQuestion(questionDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable UUID id) {
        questionServiceImp.deleteQuestion(id);
    }

}
