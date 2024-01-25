package com.quiz.model;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
	@Id
	private int id;
	private String title;
	@ManyToMany
	private List<Question> question;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Question> getQuestion() {
		return question;
	}
	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	
	
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", question=" + question + "]";
	}

}
