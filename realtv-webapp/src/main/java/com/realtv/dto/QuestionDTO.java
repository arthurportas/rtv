/**
 * 
 */
package com.realtv.dto;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.realtv.domain.Question;


/**
 * @author Arthur Portas
 * @date 13/01/2014
 */
public class QuestionDTO {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(QuestionDTO.class);
	
	private final static ObjectMapper objectMapper = new ObjectMapper();
	private final static JaxbJacksonObjectMapper jaxbJacksonObjectMapper = new JaxbJacksonObjectMapper();
	
	/*
	 * @param question
	 *            - {@link Question} to be sent, see 'question_message.json'
	 *            Build question message to be sent by producer
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * */
	public static String composeQuestionMessage(Question question) throws JsonGenerationException, JsonMappingException, IOException {

		slf4jLogger.info("==String composeQuestionMessage(final Question question) throws JsonGenerationException, JsonMappingException, IOException==");
		
		StringBuilder sb = new StringBuilder();
		
        String json = objectMapper.writeValueAsString(question);
        sb.append("[ \"questionMessage\" , ");
        sb.append(json);
        sb.append("]");
        slf4jLogger.debug(sb.toString());       
		return sb.toString();
	}
	
	public static Question getQuestionEntityFromMessage(String message) throws JsonGenerationException, JsonMappingException, IOException {
		
		slf4jLogger.info("==Question getQuestionEntityFromMessage(String message) throws JsonGenerationException, JsonMappingException, IOException==");
		final Question question = jaxbJacksonObjectMapper.readValue(message, Question.class);
		return question;
		
	}
}
