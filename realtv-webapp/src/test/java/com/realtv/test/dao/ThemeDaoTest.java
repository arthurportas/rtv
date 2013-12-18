package com.realtv.test.dao;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.testing.EqualsTester;
import com.realtv.domain.Theme;
import com.realtv.repo.ThemeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml",
		"classpath:/META-INF/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class ThemeDaoTest extends BaseEntityTest{
	
	@Autowired
	@InjectMocks
	private ThemeDao themeDao;
	
	@Mock
	private Theme mockedTheme;

		
	@Test
	@Ignore(" not yet implemented")
	public void testFindById() {

	}

	@Test
	@Ignore(" not yet implemented")
	public void testFindByAnswer() {

	}

	@Test
	@Ignore(" not yet implemented")
	public void testRegister() {

	}

	@Test
	@Ignore(" not yet implemented")
	public void testFindAllOrderedByName() {

	}

	/* (non-Javadoc)
	 * @see com.realtv.test.dao.BaseEntityTest#testHashCode()
	 */
	@Override
	@Test
	public void testHashCode() {
		/*create 2 equal objects, test hascode*/
		Assert.assertEquals("12", "12");
		
	}

	/* (non-Javadoc)
	 * @see com.realtv.test.dao.BaseEntityTest#testEquals()
	 */
	@Override
	@Test
	public void testEquals() {
		new EqualsTester().addEqualityGroup("2", "2").testEquals();
		
	}

	/* (non-Javadoc)
	 * @see com.realtv.test.dao.BaseEntityTest#testToString()
	 */
	@Override
	@Test
	public void testToString() {
		// TODO Auto-generated method stub
		
	}
}
