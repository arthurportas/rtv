/**
 * 
 */
package com.realtv.test.dto.interfaces;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

/**
 * @author Arthur Portas
 * @date 25/01/2014
 */
public interface IQuestionDTOTest {
	/**
	 * 
	 * */
	public void questionAsJson() throws JsonGenerationException,
	JsonMappingException, IOException;
	
	/**
	 * 
	 * */
	public void jsonToQuestion() throws JsonGenerationException,
	JsonMappingException, IOException;
}
