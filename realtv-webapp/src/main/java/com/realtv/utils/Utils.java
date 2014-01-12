/**
 * 
 */
package com.realtv.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Arthur Portas
 * @date 01/01/2014
 */
public class Utils {
	
	private static final Logger slf4jLogger = LoggerFactory
			.getLogger(Utils.class);

	private static final String SHA1_ALGORITHM = "SHA1";
	
	public static long questionId = 1L;
	
	public static String getSha1Digest(){
		slf4jLogger.info("==String getSha1Digest()==");
		try {
			return MessageDigest.getInstance(SHA1_ALGORITHM).toString();
		} catch (NoSuchAlgorithmException e) {
			slf4jLogger.debug("==NoSuchAlgorithmException==" + e.getMessage());
		}
		return "";
	}
}
