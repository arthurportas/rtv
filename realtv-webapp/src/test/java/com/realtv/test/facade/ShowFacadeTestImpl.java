/**
 * 
 */
package com.realtv.test.facade;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.realtv.domain.ClientHistory;
import com.realtv.domain.Show;
import com.realtv.facade.ShowFacade;
import com.realtv.test.facade.interfaces.IShowFacadeTest;

/**
 * @author Arthur Portas
 * @date 03/01/2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ShowFacadeTestImpl implements IShowFacadeTest {

	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(ShowFacadeTestImpl.class);

	@Autowired
	private ShowFacade showFacade;
	
	@Before
	public void setup() {
		showFacade = new ShowFacade();
	}

	@After
	public void tearDown() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.test.facade.interfaces.IShowFacadeTest#startDemoShow()
	 */
	@Test
	@Override
	public void startDemoShow() {
		slf4jLogger.info("==startDemoShow()==");
		assertNotNull("show should not be null", showFacade.startDemoShow());
	}

}
