package edu.ap.spring.view;

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
		 
		 if (repository.findByQuestion(newQuestion.getQuestion()) != null) {
			 Question foundQuestion = repository.findByQuestion(newQuestion.getQuestion());
			 System.out.println(foundQuestion.toString());
			 throw new Exception();
		}
		 
		 while (repository.findByAnswer(newQuestion.getAnswer()) != null) {
			 EightBall eightBall = new EightBall();
			 newQuestion = new Question(newQuestion.getQuestion(), eightBall.getRandomAnswer(newQuestion.getQuestion()));
			 repository.save(newQuestion);
			}
		 
		 
	 }
}
	