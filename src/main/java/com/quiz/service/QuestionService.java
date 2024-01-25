package com.quiz.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.quiz.dao.QuestionDao;
import com.quiz.model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String>  addQuestion(Question question) {
		try{
			questionDao.save(question);
			return new ResponseEntity<>("Success..!!",HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed..!!",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try{
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK) ;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
	}

	public ResponseEntity<String> deleteQuestion(int id) {
		try{
			Question a=questionDao.findById(id).get();
			questionDao.delete(a);
			return new ResponseEntity<>("Success..!!",HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Failed..!!",HttpStatus.BAD_REQUEST);
	}

}
