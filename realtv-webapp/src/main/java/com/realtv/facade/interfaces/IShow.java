/**
 * 
 */
package com.realtv.facade.interfaces;

import com.realtv.domain.Show;


/**
 * @author Arthur Portas
 * @date 02/01/2014
 */

public interface IShow {

	public Show startDemoShow();
	
	public void sendQuestionsEvery40Seconds();
}
