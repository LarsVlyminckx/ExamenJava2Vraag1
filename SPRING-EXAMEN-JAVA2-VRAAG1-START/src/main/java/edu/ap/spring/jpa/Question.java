package edu.ap.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {
		@Id
	   @GeneratedValue
	   private Long id;

	    private String question,answer;

	    public Question() {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
	    
		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		public Question(String question, String answer) {
			super();
			this.question = question;
			this.answer = answer;
		}

		@Override
		public String toString() {
			return "Question [id=" + id + "question=" + question + ", answer=" + answer + "]";
		}	
		
		
}
