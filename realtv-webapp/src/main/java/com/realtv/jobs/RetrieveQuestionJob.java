/**
 * 
 */
package com.realtv.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.realtv.domain.Question;
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
			slf4jLogger.info(q.toString());
			
		} catch (SchedulerException se) {
			slf4jLogger.debug(se.getMessage());
		}
	}
}
