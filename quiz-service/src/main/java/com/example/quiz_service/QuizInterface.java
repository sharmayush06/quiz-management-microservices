package com.example.quiz_service;

import com.example.quiz_service.dto.QuestionDto;
import com.example.quiz_service.dto.QuestionWrapper;
import com.example.quiz_service.dto.ResultDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "QUESTION-SERVICE")
public interface QuizInterface {

    @PostMapping("/question/selected")
    List<QuestionWrapper> getSelectedQuestions(@RequestBody QuestionDto questionDto);

    @PostMapping("/question/result")
    Integer getScore(@RequestBody List<ResultDto> resultDtos);

    @PostMapping("/question/questions")
    List<QuestionWrapper> getQuestions(@RequestBody List<Integer> ids);
}