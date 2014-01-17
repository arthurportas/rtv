/**
 * 
 */
package com.realtv.jobs;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.realtv.domain.Question;
import com.realtv.dto.QuestionDTO;
import com.realtv.services.interfaces.IQuestionService;
import com.realtv.utils.Utils;

/**
 * @author Arthur Portas
 * @date 12/01/2014
 */
public class RetrieveQuestionJob implements Job {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(RetrieveQuestionJob.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		slf4jLogger.info("==execute(JobExecutionContext context)==");
		slf4jLogger.info("==RetrieveQuestionJob run successfully...==");
		slf4jLogger.info("==questionService.find(QUESTION_ID)==");
		
		IQuestionService questionService;
		
		try {
			questionService = (IQuestionService) context.getScheduler().getContext().get("questionService");
	        
			Question q = questionService.find(Utils.questionId);
			Utils.questionId++;
			//TODO need access to messaging service to send questions
			//first contact DTo to build JSON message
			slf4jLogger.info(QuestionDTO.composeQuestionMessage(q));
			
		} catch (SchedulerException se) {
			slf4jLogger.debug(se.getMessage());
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
