/**
 * 
 */
package com.realtv.facade;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realtv.domain.ClientHistory;
import com.realtv.domain.Show;
import com.realtv.domain.ShowType;
import com.realtv.facade.interfaces.IShow;
import com.realtv.jobs.JobSchedulerService;
import com.realtv.services.interfaces.IShowService;
import com.realtv.services.interfaces.IClientHistoryService;

/**
 * @author Arthur Portas
 * @date 03/01/2014
 */
@Service
public class ShowFacade implements IShow {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(ShowFacade.class);

	/* services */
	@Autowired
	private JobSchedulerService jobSchedulerService;
	@Autowired
	private IShowService showService;
	@Autowired
	private IClientHistoryService clientHistoryService;

	/* entities */
	private Show show;
	private ShowType showType;
	private ClientHistory clientHistory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.facade.IShow#startDemoShow()
	 */
	@Override
	public Show startDemoShow() {
		slf4jLogger.info("==startDemoShow()==");
		this.show = new Show();
		this.showType = new ShowType();
		this.show.setShowType(this.showType);
		show = showService.create(this.show);
		return show;
	}

	/* (non-Javadoc)
	 * @see com.realtv.facade.IShow#sendQuestionsEvery40Seconds()
	 */
	@Override
	public void sendQuestionsEvery40Seconds() {
		slf4jLogger.info("==startDemoShow()==");
		try {
			jobSchedulerService.scheduleRetrieveQuestionJob();
		} catch (SchedulerException se) {
			slf4jLogger.debug(se.getMessage());
		}
	}
	
	/*consumers are managed by the container like MDB's
	 * each consumer, persists answer and acknowledges participation,
	 * after this it send instant stats pulled from persistence
	 * */

}
