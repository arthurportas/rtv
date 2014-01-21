/**
 * 
 */
package com.realtv.jobs;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.realtv.domain.Question;
import com.realtv.dto.QuestionDTO;
import com.realtv.messaging.SimpleMessageProducer;
import com.realtv.services.interfaces.IQuestionService;
import com.realtv.utils.Utils;

/**
 * @author Arthur Portas
 * @date 12/01/2014
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class RetrieveQuestionJob implements Job {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(RetrieveQuestionJob.class);
	public static final String EXECUTION_COUNT = "EXECUTION_COUNT";

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

		try {
			IQuestionService questionService = (IQuestionService) context
					.getScheduler().getContext().get("questionService");
			slf4jLogger.info("==questionService.find(QUESTION_ID)==");
			
			//JobDataMap data = context.getJobDetail().getJobDataMap();
			//long count = data.getLong(EXECUTION_COUNT);
			
			Question q = questionService.find(Utils.questionId);
			Utils.questionId++;
			//data.put(EXECUTION_COUNT, Utils.questionId);

			
			// first contact DTo to build JSON message
			// TODO need access to messaging service to send questions
			QuestionDTO.composeQuestionMessage(q);

			SimpleMessageProducer producer = (SimpleMessageProducer) context
					.getScheduler().getContext().get("jmsService");
			producer.convertAndSendTopic(QuestionDTO.composeQuestionMessage(q));
		} catch (SchedulerException se) {
			slf4jLogger.debug(se.getMessage());
		} catch (JsonGenerationException jge) {
			slf4jLogger.debug(jge.getMessage());
		} catch (JsonMappingException jme) {
			slf4jLogger.debug(jme.getMessage());
		} catch (IOException ioe) {
			slf4jLogger.debug(ioe.getMessage());
		}
	}
}
