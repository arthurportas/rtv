/**
 * 
 */
package com.realtv.test.jobs;

import org.quartz.SchedulerException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.realtv.jobs.JobSchedulerService;

/**
 * @author Arthur Portas
 * @date 12/01/2014
 */
public class JobSchedulerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SchedulerException,
			InterruptedException {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:test-context.xml",
				"classpath:/META-INF/spring/applicationContext.xml");

		JobSchedulerService service = (JobSchedulerService) context
				.getBean("quartzStarter");

		service.scheduleRetrieveQuestionJob();

	}

}
