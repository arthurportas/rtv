/**
 * 
 */
package com.realtv.dto;

import com.realtv.domain.Question;

/**
 * @author Arthur Portas
 * @date 13/01/2014
 */
public class QuestionDTO {

	private static StringBuilder sb = new StringBuilder();
	
	/**
	 * @param question - {@link Question} to be sent,
	 * see 'question_message.json'
	 * Build question message to be sent by producer
	 * */
	public static String composeQuestionMessage(Question question){
		sb.append(question.getQuestion());
		return sb.toString();
	}
}
