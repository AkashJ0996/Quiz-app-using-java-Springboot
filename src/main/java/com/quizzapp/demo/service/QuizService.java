package com.quizzapp.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizzapp.demo.Dao.QuestionDao;
import com.quizzapp.demo.Dao.QuizDao;
import com.quizzapp.demo.entities.Question;
import com.quizzapp.demo.entities.QuestionWrapper;
import com.quizzapp.demo.entities.Quiz;
import com.quizzapp.demo.entities.Response;

@Service
public class QuizService {
   
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> q = questionDao.findRandomQuestionsByCategory(category , numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(q);
		quizDao.save(quiz);
		
		return new ResponseEntity<String>("Success",HttpStatus.CREATED) ;
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		/*this findById() method will might not return the data we want from database for id which is not exist so it will 
		  throw null error so to handle this we declare Optional cause we are not sure about the data.*/  
		 Optional<Quiz> quiz = quizDao.findById(id); 
		 List<Question> questionsFromDb = quiz.get().getQuestions();
		 //converting each questions into wrapper class
		 List<QuestionWrapper> questionsForUser = new ArrayList<>();
		 
		 //to add data into empty arraylist
		 for(Question q :questionsFromDb) {
			 QuestionWrapper qwrap = new QuestionWrapper(q.getId(),q.getQuestionlist() ,q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			 questionsForUser.add(qwrap);
		 }
		 
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		
		Quiz quiz =quizDao.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		
		//letc check response given by user is correct or not 
		int right = 0 ;
		int i = 0;
		for(Response ans : responses) {
			if(ans.getResponseAns().equals(questions.get(i).getRightans()))
				right++;
			
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
	
}
