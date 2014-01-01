/**
 * 
 */
package com.realtv.test.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.realtv.services.ClientHistoryService;

/**
 * @author Arthur Portas
 * @date 31/12/2013
 */
@RunWith(Suite.class)
@SuiteClasses({ AnswerServiceTestImpl.class,
		QuestionLevelServiceTestImpl.class, QuestionServiceTestImpl.class,
		ShowServiceTestImpl.class, ShowTypeServiceTestImpl.class,
		ThemeServiceTestImpl.class, ClientServiceTestImpl.class,
		AndroidNotificationServerServiceTestImpl.class,
		ClientHistoryService.class})
public class AllServiceTests {

}
