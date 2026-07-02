package com.example.quiz_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapper {
    Integer questionId;
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
}
