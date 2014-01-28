/**
 * 
 */
package com.realtv.jobs;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
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
public class SendQuestionJob implements Job {

	private final static Logger slf4jLogger = LoggerFactory
			.getLogger(SendQuestionJob.class);
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
		slf4jLogger.info("==SendQuestionJob run successfully...==");

		try {
			IQuestionService questionService = (IQuestionService) context
					.getScheduler().getContext().get("questionService");
			
			Question question = questionService.find(Utils.questionId);
			Utils.questionId++;

			SimpleMessageProducer producer = (SimpleMessageProducer) context
					.getScheduler().getContext().get("jmsService");
			producer.convertAndSendTopic(QuestionDTO.composeQuestionMessage(question));
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
