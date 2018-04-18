package edu.ap.spring.model;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class EightBall {
	
	private String[] answers = {"It is certain", 
								"Yes definitely", 
								"Most likely",
								"Outlook good",
								"Better not tell you now",
								"Cannot predict now",
								"Don't count on it", 
								"Outlook not so good"};
	
	public String getRandomAnswer(String question) {
		int rnd = new Random().nextInt(answers.length);
		return answers[rnd];
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
}
