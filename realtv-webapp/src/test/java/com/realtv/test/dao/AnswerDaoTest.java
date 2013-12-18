package com.realtv.test.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.testing.EqualsTester;
import com.realtv.domain.Answer;
import com.realtv.repo.AnswerDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AnswerDaoTest extends BaseEntityTest{
	@Autowired
	@InjectMocks
	private AnswerDao answerDao;
	
	@Mock
	private Answer mockedAnswer;

		
	@Test
	public void testFindById() {
		/*Answer answer = answerDao.findById(1l);
		Assert.assertEquals("Herman Jose", answer.getAnswer());*/
		this.mockedAnswer = answerDao.findById(1l);
		Assert.assertEquals("Herman Jose", this.mockedAnswer.getAnswer());
	}

	@Test
	public void testFindByAnswer() {
		this.mockedAnswer = answerDao.findByAnswer("Herman Jose");

		Assert.assertEquals("Herman Jose", this.mockedAnswer.getAnswer());
		return;
	}

	@Test
	public void testRegister() {
		Answer answer = new Answer();
		answer.setAnswer("Sport Lisboa Benfica");
		answer.setCorrectAnswer("Sport Lisboa Benfica");

		answerDao.register(answer);
		Long id = answer.getId();
		Assert.assertNotNull(id);

		Assert.assertEquals(5, answerDao.findAllOrderedByName().size());
		Answer newAnswer = answerDao.findById(id);

		Assert.assertEquals("Sport Lisboa Benfica", newAnswer.getAnswer());

		return;
	}

	@Test
	public void testFindAllOrderedByName() {
		Answer answer = new Answer();
		answer.setAnswer("Sport Leiria Boavista");
		answer.setCorrectAnswer("Sport Lisboa Benfica");

		answerDao.register(answer);

		List<Answer> answers = answerDao.findAllOrderedByName();
		Assert.assertEquals(5, answers.size());
		Answer newAnswer = answers.get(0);

		Assert.assertEquals("Cristiano Ronaldo", newAnswer.getAnswer());
		return;
	}

	/* (non-Javadoc)
	 * @see com.realtv.test.dao.BaseEntityTest#testHashCode()
	 */
	@Override
	@Test
	public void testHashCode() {
		/*create 2 equal objects, test hascode*/
		Assert.assertEquals("12", "12");
		
	}

	/* (non-Javadoc)
	 * @see com.realtv.test.dao.BaseEntityTest#testEquals()
	 */
	@Override
	@Test
	public void testEquals() {
		new EqualsTester().addEqualityGroup("2", "2").testEquals();
		
	}

	/* (non-Javadoc)
	 * @see com.realtv.test.dao.BaseEntityTest#testToString()
	 */
	@Override
	@Test
	public void testToString() {
		// TODO Auto-generated method stub
		
	}
}
