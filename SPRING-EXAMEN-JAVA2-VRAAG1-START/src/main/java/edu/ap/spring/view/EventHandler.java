package edu.ap.spring.view;

import java.awt.event.ActionEvent;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import edu.ap.spring.model.EightBall;

@Service
public class EventHandler {

    private UI ui;
    private QuestionRepository repository;
    
    @Autowired
    public void setRepository(QuestionRepository repository) {
    		this.repository = repository;
    }
    
    @Autowired
    public void setUI(UI ui) {
    		this.ui = ui;
    }

    public void whenButtonClicked(ActionEvent actionEvent) {
    	try {
    		EightBall eightBall = new EightBall();
    		String[] antwoorden= eightBall.getAnswers();
    		int rnd = new Random().nextInt(antwoorden.length);
    		String antwoord = antwoorden[rnd];
        
    		String vraag = ui.getQuestion().getText();        
       
    		Question question = new Question(vraag, antwoord);
    		repository.save(question);

    		System.out.println(question.toString() + " saved in repository");
    		/*System.out.println("Find all : ") ;
        	repository.findAll().forEach(System.out::println);*/
    	} catch (Exception e) {	}
    }
}