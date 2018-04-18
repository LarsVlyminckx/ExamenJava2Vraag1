package edu.ap.spring.view;

import java.util.Random;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import edu.ap.spring.model.EightBall;

@Aspect
@Component
public class AOPHandler {

	@Autowired
	private QuestionRepository repository;
	
	 @Before("execution(* edu.ap.spring.jpa.QuestionRepository.save(..))")
	 public void checkBeforeSaveUser(JoinPoint joinPoint) throws Exception {
		 Question newQuestion = (Question)joinPoint.getArgs()[0];
		 
		 if (repository.findByAnswer(newQuestion.getAnswer()) != null) {
			 Question foundAnswer = repository.findByQuestion(newQuestion.getQuestion());
			 System.out.println("Dit antwoord is gegeven!");
			 /*EightBall eightBall = new EightBall();
			 String[] antwoorden= eightBall.getAnswers();
			 int rnd = new Random().nextInt(antwoorden.length);
			 String antwoord = antwoorden[rnd];
			 System.out.println(foundAnswer.toString());*/
			 throw new Exception();
		}
		 
		 if (repository.findByQuestion(newQuestion.getQuestion()) != null) {
			 Question foundQuestion = repository.findByQuestion(newQuestion.getQuestion());
			 System.out.println("Deze vraag is al gesteld!");
			 System.out.println(foundQuestion.toString());
			 throw new Exception();
		}
		 
		 
	 }
}
	