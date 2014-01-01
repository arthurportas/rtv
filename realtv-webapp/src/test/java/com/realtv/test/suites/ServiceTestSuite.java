/**
 * 
 */
package com.realtv.test.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.realtv.test.services.AndroidNotificationServerServiceTestImpl;
import com.realtv.test.services.AnswerServiceTestImpl;
import com.realtv.test.services.ClientHistoryServiceTestImpl;
import com.realtv.test.services.ClientServiceTestImpl;
import com.realtv.test.services.QuestionLevelServiceTestImpl;
import com.realtv.test.services.QuestionServiceTestImpl;
import com.realtv.test.services.ShowParticipationServiceTestImpl;
import com.realtv.test.services.ShowServiceTestImpl;
import com.realtv.test.services.ShowTypeServiceTestImpl;
import com.realtv.test.services.ThemeServiceTestImpl;

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
		ClientHistoryServiceTestImpl.class, AnswerServiceTestImpl.class,
		ShowParticipationServiceTestImpl.class})
public class ServiceTestSuite {

}
