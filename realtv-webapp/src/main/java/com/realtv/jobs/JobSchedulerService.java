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
import com.realtv.services.interfaces.IQuestionService;
import com.realtv.utils.Utils;
/**
 * @author Arthur Portas
 * @date 12/01/2014
 */
@Service("quartzStarter")
public class JobSchedulerService {

	@Autowired
	private IQuestionService questionService;
	@Autowired
	private SimpleMessageProducer producer;
	@Autowired
    private NotificationRegistry registry;
	
	private Scheduler scheduler;
	
	public void scheduleRetrieveQuestionJob() throws SchedulerException{

		try {

			if(this.scheduler==null){
				this.scheduler = StdSchedulerFactory.getDefaultScheduler();	
			}
			this.scheduler.getContext().put("questionService", questionService);
			this.scheduler.getContext().put("jmsService", producer);
			
			
			// specify the job' s details..
			JobDetail job = JobBuilder.newJob(RetrieveQuestionJob.class)
					.withIdentity("retrieveQuestionJob").build();

			job.getJobDataMap().put(RetrieveQuestionJob.EXECUTION_COUNT, Utils.questionId);
			this.scheduler.start();
			
			// specify the running period of the job
			Trigger trigger = TriggerBuilder
					.newTrigger()
					.withSchedule(
							SimpleScheduleBuilder.simpleSchedule()
									.withIntervalInSeconds(40).repeatForever())
					.build();

			// schedule the job
			this.scheduler.scheduleJob(job, trigger);

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
