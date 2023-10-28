package com.quizzapp.demo.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quizzapp.demo.entities.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{
	
	List<Question> findByCategory(String category);

	@Query(value="SELECT * FROM question q WHERE q.category = ?1 ORDER BY RAND() LIMIT ?2", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String category, int numQ);
  
}
