package com.example.quiz_service.service;

import com.example.quiz_service.QuizInterface;
import com.example.quiz_service.dto.QuestionDto;
import com.example.quiz_service.dto.QuestionWrapper;
import com.example.quiz_service.dto.ResultDto;
import com.example.quiz_service.model.Quiz;
import com.example.quiz_service.repo.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizInterface quizInterface;

    public ResponseEntity<List<QuestionWrapper>> createQuiz(QuestionDto questionDto) {

        List<QuestionWrapper> questions =
                quizInterface.getSelectedQuestions(questionDto);

        List<Integer> ids = new ArrayList<>();

        for (QuestionWrapper question : questions) {
            ids.add(question.getQuestionId());
        }

        Quiz quiz = new Quiz();
        quiz.setQuestionIds(ids);

        quizRepository.save(quiz);

        return new ResponseEntity<>(questions, HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {

        Quiz quiz = quizRepository.findById(id).orElse(null);

        if (quiz == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<QuestionWrapper> questions =
                quizInterface.getQuestions(quiz.getQuestionIds());

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
    public ResponseEntity<Integer> result(List<ResultDto> resultDtos) {

        Integer score = quizInterface.getScore(resultDtos);

        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}