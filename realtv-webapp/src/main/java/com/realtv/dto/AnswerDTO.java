/**
 * 
 */
package com.realtv.dto;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.realtv.domain.Answer;

/**
 * @author Arthur Portas
 * @date 13/01/2014
 */
public class AnswerDTO {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(AnswerDTO.class);

	private final static JaxbJacksonObjectMapper jaxbJacksonObjectMapper = new JaxbJacksonObjectMapper();

	/*
	 * @param answer - {@link Answer} to be sent, see 'answer_message.json'
	 * Build answer message to be sent by producer, and consumed
	 * 
	 * @throws IOException
	 * 
	 * @throws JsonMappingException
	 * 
	 * @throws JsonGenerationException
	 */
	public static String composeAnswerMessage(Answer answer, String clientEmail)
			throws JsonGenerationException, JsonMappingException, IOException, JSONException {

		slf4jLogger
				.info("==String composeAnswerMessage(Answer answer) throws JsonGenerationException, JsonMappingException, IOException==");

		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("id", answer.getId());
		jsonObject.put("clientID", clientEmail);
		jsonObject.put("answer", answer.getAnswer());//review
		
		StringBuilder sb = new StringBuilder();

		
		sb.append("[ \"answerMessage\" , ");
		//sb.append(json);
		sb.append("]");
		slf4jLogger.debug(sb.toString());
		return sb.toString();
	}

	// como consumir resposta do cliente?

}
