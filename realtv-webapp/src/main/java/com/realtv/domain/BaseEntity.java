/**
 * 
 */
package com.realtv.domain;

/**
 * @author Arthur Portas
 * @date 17/12/2013
 */
public abstract class BaseEntity {

	/**
	 * HashCode
	 * */
	public abstract int hashCode();
	/**
	 * Equals
	 * */
	public abstract boolean equals(Object obj);
	/**
	 * ToString
	 * */
	public abstract String toString();
	/**
	 * ToJson
	 * */
	public abstract String toJson();
	
}
