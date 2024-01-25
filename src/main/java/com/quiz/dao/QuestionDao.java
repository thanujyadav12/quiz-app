package com.quiz.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.quiz.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
	
	public List<Question> findByCategory(String category);
	
	@Query(value="SELECT * FROM (SELECT * FROM QUESTION WHERE category = ?1 ORDER BY DBMS_RANDOM.VALUE) WHERE ROWNUM <= ?2", nativeQuery = true)
	public List<Question> findRandomQuestionsByCategory(String category, int numQ);

}
