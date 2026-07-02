package com.example.quiz_service.controller;

import com.example.quiz_service.dto.QuestionDto;
import com.example.quiz_service.dto.QuestionWrapper;
import com.example.quiz_service.dto.ResultDto;
import com.example.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<List<QuestionWrapper>> createQuiz(@RequestBody QuestionDto questionDto){
        return quizService.createQuiz(questionDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuiz(id);
    }

    @PostMapping("/result")
    public ResponseEntity<Integer> result(@RequestBody List<ResultDto> resultDtos){
        return quizService.result(resultDtos);
    }
}
