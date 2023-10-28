package com.quizzapp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizzapp.demo.Dao.QuestionDao;
import com.quizzapp.demo.entities.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public List<Question> getAllQuestions() {
		List<Question> all = questionDao.findAll();
		return all ;
	}
	
	public List<Question> getAllQuesByCategory(String category) {
		List<Question> c = questionDao.findByCategory(category);
		return c;
	}
	
	public Question addQuestions(Question question) {
		Question save = questionDao.save(question);
		return save;
	}
	
	public Question updateQuestions(Question question) {
		Question savedUpdate = questionDao.save(question);
		
		return savedUpdate;
	}
	
	public String deleteQuestions(Integer id) {
		questionDao.deleteById(id);
		return "Deleted Successfully";
	}
}
