/**
 * 
 */
package com.realtv.jobs;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtv.messaging.NotificationRegistry;
import com.realtv.messaging.SimpleMessageProducer;
import com.realtv.services.interfaces.IAnswerService;
import com.realtv.services.interfaces.IQuestionService;
import com.realtv.utils.Utils;

/**
 * @author Arthur Portas
 * @date 12/01/2014
 */
@Service("quartzStarter")
public class JobSchedulerService {

	// log

	@Autowired
	private IQuestionService questionService;
	@Autowired
	private IAnswerService answerService;
	@Autowired
	private SimpleMessageProducer producer;
	@Autowired
	private NotificationRegistry registry;

	private Scheduler scheduler;

	public void scheduleRetrieveQuestionJob() throws SchedulerException {

		try {

			if (this.scheduler == null) {
				this.scheduler = StdSchedulerFactory.getDefaultScheduler();
			}
			this.scheduler.getContext().put("questionService", questionService);
			this.scheduler.getContext().put("jmsService", producer);
			this.scheduler.getContext().put("answerService", answerService);

			// specify the sendQuestionJob details..
			JobDetail sendQuestionJob = JobBuilder
					.newJob(SendQuestionJob.class)
					.withIdentity("sendQuestionJob").build();

			sendQuestionJob.getJobDataMap().put(
					SendQuestionJob.EXECUTION_COUNT, Utils.questionId);

			// specify the sendQuestionJob details..
			JobDetail sendAnswerJob = JobBuilder.newJob(SendAnswerJob.class)
					.withIdentity("sendAnswerJob").build();

			sendAnswerJob.getJobDataMap().put(SendAnswerJob.EXECUTION_COUNT,
					Utils.questionId);

			this.scheduler.start();

			// Trigger the sendQuestionJob to run now, and then every 40 seconds
			Trigger sendQuestionTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("sendQuestionTrigger")
					.startNow()
					.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
									.withIntervalInSeconds(40)
									.withRepeatCount(15)).build();

			// Trigger the sendAnswerJob to run now, and then every 45 seconds
			Trigger sendAnswerTrigger = TriggerBuilder
					.newTrigger()
					.withIdentity("sendAnswerTrigger")
					.startNow()
					.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
									.withIntervalInSeconds(45)
									.withRepeatCount(15)).build();

			// schedule the job
			this.scheduler.scheduleJob(sendQuestionJob, sendQuestionTrigger);
			this.scheduler.scheduleJob(sendAnswerJob, sendAnswerTrigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
