package com.quizzapp.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizzapp.demo.entities.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
