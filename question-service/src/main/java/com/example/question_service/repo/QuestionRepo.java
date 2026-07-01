package com.example.question_service.repo;

import com.example.question_service.dto.QuestionDto;
import com.example.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
    @Query(value = "SELECT * FROM Question where difficulty = :difficulty AND category = :category ORDER BY RAND() LIMIT :questionNo",nativeQuery = true)
    List<Question> getSelectedQuestions(@Param("category")String category, @Param("difficulty")String difficulty , @Param("questionNo") Integer questionNo);
}
