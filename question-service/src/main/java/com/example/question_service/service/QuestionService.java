package com.example.question_service.service;

import com.example.question_service.dto.QuestionDto;
import com.example.question_service.dto.QuestionWrapper;
import com.example.question_service.dto.ResultDto;
import com.example.question_service.model.Question;
import com.example.question_service.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionRepo.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getSelectedQuestions(QuestionDto questionDto) {
        List<Question>questions=questionRepo.getSelectedQuestions(questionDto.getCategory(),questionDto.getDifficulty(),questionDto.getQuestionNo());
        List<QuestionWrapper>questionWrappers=new ArrayList<>();
        for(Question question:questions){
            QuestionWrapper questionWrapper=new QuestionWrapper();
            questionWrapper.setQuestionId(question.getQuestionId());
            questionWrapper.setQuestion(question.getQuestion());
            questionWrapper.setOption1(question.getOption1());
            questionWrapper.setOption2(question.getOption2());
            questionWrapper.setOption3(question.getOption3());
            questionWrapper.setOption4(question.getOption4());
            questionWrappers.add(questionWrapper);
        }
        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(List<ResultDto> resultDtos) {
        Integer score = 0;
        for(ResultDto resultDto:resultDtos){
            Question question =questionRepo.findById(resultDto.getQuestionId()).orElse(null);
            if(resultDto.getSelectedOption().equals(question.getCorrectOption())){
                score++;
            }
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }

    public ResponseEntity<?> addQuestion(Question question) {
        return new ResponseEntity<>(questionRepo.save(question),HttpStatus.ACCEPTED);
    }
}
