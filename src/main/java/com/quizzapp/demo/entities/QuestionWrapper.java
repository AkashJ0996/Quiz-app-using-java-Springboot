package com.quizzapp.demo.entities;

import lombok.Data;

@Data
public class QuestionWrapper {
	
	
	private Integer id ;
	private String  questionlist ;
	private String  option1 ;
	private String  option2 ;
	private String  option3 ;
	private String  option4 ;
	
	
	
	public QuestionWrapper(Integer id,String questionlist ,String option1, String option2, String option3, String option4
			) {
		super();
		this.id = id;
		this.questionlist = questionlist;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		
	}
	
	

}
