package com.realtv.test.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.Answer;
import com.realtv.domain.Question;
import com.realtv.repo.QuestionDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class QuestionDaoTest {
	@Autowired
	private QuestionDao questionDao;

	@Test
	public void testFindById() {
		Question question = questionDao.findById(1l);

		Assert.assertEquals("Quem foi o 1 Rei de Portugal?",
				question.getQuestion());
		return;
	}

	@Test
	public void testFindByQuestion() {
		Question question = questionDao
				.findByQuestion("Quem foi o 1 Rei de Portugal?");

		Assert.assertEquals("Quem foi o 1 Rei de Portugal?",
				question.getQuestion());
		return;
	}

	@Test
	public void testRegister() {
		
		Question question = new Question();
		question.setQuestion("Quem foi Pélé?");
		Answer a = new Answer();
		a.setAnswer("Dançarino");
		a.setCorrectAnswer("Jogador futebol");
		List<Answer> l = new ArrayList<Answer>();
		l.add(a);
		question.setAnswers(l);
		
		questionDao.register(question);
		Long id = question.getId();
		Assert.assertNotNull(id);

		Assert.assertEquals(2, questionDao.findAllOrderedByName().size());
		Question newQuestion = questionDao.findById(id);

		Assert.assertEquals("Quem foi Pélé?", newQuestion.getQuestion());

		return;
	}

	@Test
	public void testFindAllOrderedByQuestionName() {
		Question question = new Question();
		question.setQuestion("Quem foi Eusébio?");
		Answer a = new Answer();
		a.setAnswer("Dançarino");
		a.setCorrectAnswer("Jogador futebol");
		List<Answer> l = new ArrayList<Answer>();
		l.add(a);
		question.setAnswers(l);
		
		questionDao.register(question);

		List<Question> questions = questionDao.findAllOrderedByName();
		Assert.assertEquals(2, questions.size());
		Question newQuestion = questions.get(0);

		Assert.assertEquals("Quem foi Eusébio?", newQuestion.getQuestion());
		return;
	}

	@Test
	public void testFindAllQuestions() {

		for (int i = 0; i < 10; i++) {
			Question question = new Question();
			question.setQuestion("Quem foi Maradona[" + i + "]?");
			Answer a = new Answer();
			a.setAnswer("Dançarino");
			a.setCorrectAnswer("Jogador futebol");
			List<Answer> l = new ArrayList<Answer>();
			l.add(a);
			question.setAnswers(l);
			
			questionDao.register(question);
		}

		List<Question> questions = questionDao.findAllOrderedByName();
		Assert.assertEquals(11, questions.size());
		Question newQuestion = questions.get(0);

		Assert.assertEquals("Quem foi Maradona[0]?", newQuestion.getQuestion());
		return;
	}
	
	@Test
	public void findByQuestionNamedQuery(){
		Question q = questionDao.findByQuestionNamedQuery("Quem foi o 1 Rei de Portugal?");
		Assert.assertNotNull("question should not be null", q);
	}
	
	@Test
	public void findAnswersByQuestionNamedQuery() {
		List<Answer> answers = questionDao.findAnswersByQuestionNamedQuery("Quem foi o 1 Rei de Portugal?");
		Assert.assertNotNull("answers should not be null", answers);
		Assert.assertEquals(4, answers.size());
		Answer a = answers.get(0);
		Assert.assertEquals("Herman Jose", a.getAnswer());
	}
	
}
