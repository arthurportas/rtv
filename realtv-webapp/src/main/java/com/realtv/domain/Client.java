package com.realtv.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.GsonBuilder;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "mobileID"))
@NamedQueries({ @NamedQuery(name = "Client.FIND_ALL", query = "select c from Client c") })
@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Client extends BaseEntity implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Client.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Size(min = 1, max = 255)
	private String clientGCMRegistrationID;

	@NotNull
	@Size(min = 1, max = 255)
	private String mobileID;/*default first gmail registered on device*/

	@Size(min = 1, max = 255)
	private String userName;

	@Size(min = 1, max = 255)
	private String password;/*SHA-1*/
		
	/* ==========================GETTERS/SETTERS======================= */

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getClientGCMRegistrationID() {
		return clientGCMRegistrationID;
	}

	@XmlElement
	public void setClientGCMRegistrationID(String clientGCMRegistrationID) {
		this.clientGCMRegistrationID = clientGCMRegistrationID;
	}
	
	public String getMobileID() {
		return mobileID;
	}

	@XmlElement
	public void setMobileID(String mobileID) {
		this.mobileID = mobileID;
	}
	
	public String getUserName() {
		return userName;
	}

	@XmlElement
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

	/* ==========================CONSTRUCTOR======================= */

	public Client() {

	}

	/* ====================HASHCODE,EQUALS,TOSTRING================= */
	/**
	 * Uses Guava to assist in providing hash code of this answer instance.
	 * 
	 * @return My hash code.
	 */

	@Override
	public int hashCode() {
		return com.google.common.base.Objects.hashCode(this.mobileID);
	}

	/**
	 * Using Guava to compare provided object to me for equality.
	 * 
	 * @param obj
	 *            Object to be compared to me for equality.
	 * @return {@code true} if provided object is considered equal to me or
	 *         {@code false} if provided object is not considered equal to me.
	 */

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Client other = (Client) obj;

		return com.google.common.base.Objects.equal(this.mobileID, other.mobileID);
	}

	/**
	 * Method using Guava to provide String representation of this answer
	 * instance.
	 * 
	 * @return My String representation.
	 */

	@Override
	public String toString() {
		return com.google.common.base.Objects.toStringHelper(this)
				.addValue(this.mobileID).toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.domain.BaseEntity#toJson()
	 */
	@Override
	public String toJson() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this).toString();
	}
}