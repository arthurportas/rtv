/**
 * 
 */
package com.realtv.dto;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.realtv.domain.Answer;
import com.realtv.domain.Question;

/**
 * @author Arthur Portas
 * @date 13/01/2014
 */
public class QuestionDTO {

	private static StringBuilder sb = new StringBuilder();

	/**
	 * @param question
	 *            - {@link Question} to be sent, see 'question_message.json'
	 *            Build question message to be sent by producer
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * */
	public static String composeQuestionMessage(Question question) throws JsonGenerationException, JsonMappingException, IOException {
		//create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(question);
		return json;
	}
}
