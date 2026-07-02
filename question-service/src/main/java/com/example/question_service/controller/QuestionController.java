package com.example.question_service.controller;

import com.example.question_service.dto.QuestionDto;
import com.example.question_service.dto.QuestionWrapper;
import com.example.question_service.dto.ResultDto;
import com.example.question_service.model.Question;
import com.example.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping("/add")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @PostMapping("/selected")
    public ResponseEntity<List<QuestionWrapper>> getSelectedQuestions(@RequestBody QuestionDto questionDto){
        return questionService.getSelectedQuestions(questionDto);
    }

    @PostMapping("/result")
    public ResponseEntity<Integer> calculateResult(@RequestBody List<ResultDto> resultDtos){
        return questionService.calculateResult(resultDtos);
    }
}
