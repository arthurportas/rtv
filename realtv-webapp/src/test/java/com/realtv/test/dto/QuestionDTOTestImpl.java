/**
 * 
 */
package com.realtv.test.dto;

import static org.junit.Assert.*;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.Question;
import com.realtv.dto.QuestionDTO;
import com.realtv.test.dto.interfaces.IQuestionDTOTest;

/**
 * @author Arthur Portas
 * @date 25/01/2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class QuestionDTOTestImpl implements IQuestionDTOTest{

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(QuestionDTOTestImpl.class);

	private final static String QUESTION_AS_JSON_CHANGED = "[ \"questionMessage\" , {\"id\":1,\"question\":\"Quem foi o 1 Rei de Portugal?\",\"answers\":[{\"id\":1,\"answer\":\"Herman Jose\",\"correctAnswer\":\"D. Afonso Henriques\"},{\"id\":2,\"answer\":\"Cristiano Ronaldo\",\"correctAnswer\":\"D. Afonso Henriques\"},{\"id\":3,\"answer\":\"D. Dinis\",\"correctAnswer\":\"D. Afonso Henriques\"},{\"id\":4,\"answer\":\"D. Afonso Henriques\",\"correctAnswer\":\"D. Afonso Henriques\"}]}]";
	private final static String QUESTION_AS_JSON = "{\"id\":1,\"question\":\"Quem foi o 1 Rei de Portugal?\",\"answers\":[{\"id\":1,\"answer\":\"Herman Jose\",\"correctAnswer\":\"D. Afonso Henriques\"},{\"id\":2,\"answer\":\"Cristiano Ronaldo\",\"correctAnswer\":\"D. Afonso Henriques\"},{\"id\":3,\"answer\":\"D. Dinis\",\"correctAnswer\":\"D. Afonso Henriques\"},{\"id\":4,\"answer\":\"D. Afonso Henriques\",\"correctAnswer\":\"D. Afonso Henriques\"}]}";

	@Test
	public void questionAsJson() throws JsonGenerationException,
			JsonMappingException, IOException {
		slf4jLogger.info("==questionAsJson()==");
		assertTrue("Should be equal", QUESTION_AS_JSON.equals(QUESTION_AS_JSON));
	}

	/* (non-Javadoc)
	 * @see com.realtv.test.dto.interfaces.IQuestionDTOTest#jsonToQuestion()
	 */
	@Override
	public void jsonToQuestion() throws JsonGenerationException,
			JsonMappingException, IOException {
		assertNotNull("Question should not be null",
				QuestionDTO.getQuestionEntityFromMessage(QUESTION_AS_JSON));
		final Question question = QuestionDTO
				.getQuestionEntityFromMessage(QUESTION_AS_JSON);

		assertTrue("Should be equal",
				question.getQuestion().equals("Quem foi o 1 Rei de Portugal?"));
		
	}
}
