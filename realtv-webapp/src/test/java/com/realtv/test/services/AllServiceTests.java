/**
 * 
 */
package com.realtv.test.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Arthur Portas
 * @date 31/12/2013
 */
@RunWith(Suite.class)
@SuiteClasses({ AnswerServiceTestImpl.class,
		QuestionLevelServiceTestImpl.class, QuestionServiceTestImpl.class,
		ShowServiceTestImpl.class, ShowTypeServiceTestImpl.class,
		ThemeServiceTestImpl.class, ClientServiceTestImpl.class })
public class AllServiceTests {

}
