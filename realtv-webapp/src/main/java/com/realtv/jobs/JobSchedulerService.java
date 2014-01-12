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

import com.realtv.services.interfaces.IQuestionService;
/**
 * @author Arthur Portas
 * @date 12/01/2014
 */
@Service("quartzStarter")
public class JobSchedulerService {

	@Autowired
	private IQuestionService questionService;
	private Scheduler scheduler;
	
	public void scheduleRetrieveQuestionJob() throws SchedulerException{

		try {

			if(this.scheduler==null){
				this.scheduler = StdSchedulerFactory.getDefaultScheduler();	
			}
			this.scheduler.getContext().put("questionService", questionService);
			this.scheduler.start();
			
			// specify the job' s details..
			JobDetail job = JobBuilder.newJob(RetrieveQuestionJob.class)
					.withIdentity("retrieveQuestionJob").build();

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
