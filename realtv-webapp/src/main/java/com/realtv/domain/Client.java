package com.realtv.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.GsonBuilder;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "mobileID"))
@NamedQueries({ @NamedQuery(name = "Client.FIND_ALL", query = "select c from Client c") })
@XmlRootElement(name = "client")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Client extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Client.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Size(min = 1, max = 255)
	private String clientGCMRegistrationID = StringUtils.EMPTY;

	@NotNull
	@Email
	@Size(min = 1, max = 255)
	@Value("${Client.mobileID}")
	private String mobileID;

	@Size(min = 1, max = 80)
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "must contain only letters, numbers and spaces")
	private String userName = StringUtils.EMPTY;

	@Size(min = 1, max = 255)
	private String password;/* SHA-1 */

	/* relation to AndroidNotificationServer */
	@ManyToOne
	@JoinColumn(name = "AndroidNotificationServerId")
	private AndroidNotificationServer androidNotificationServer;

	/* relation to ClientHistory */
	@ManyToOne
	@JoinColumn(name = "clientHistoryId")
	private ClientHistory clientHistory;

	@ManyToOne
	@JoinColumn(name = "ShowParticipationId")
	private ShowParticipation showParticipation;

	/* ==========================GETTERS/SETTERS======================= */

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id - the id to set
	 */
	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return clientGCMRegistrationID
	 */
	public String getClientGCMRegistrationID() {
		return clientGCMRegistrationID;
	}

	/**
	 * @param clientGCMRegistrationID - the clientGCMRegistrationID to set.
	 * Client registers within GCM cloud servers for push notifications
	 */
	@XmlElement
	public void setClientGCMRegistrationID(String clientGCMRegistrationID) {
		this.clientGCMRegistrationID = clientGCMRegistrationID;
	}

	/**
	 * @return mobileID
	 */
	public String getMobileID() {
		return mobileID;
	}

	/**
	 * @param mobileID - the mobileID to set.
	 * Client's first gmail account on device
	 */
	@XmlElement
	public void setMobileID(String mobileID) {
		this.mobileID = mobileID;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName - the userName to set.
	 */
	@XmlElement
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return password(SHA-1)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password - the password to set.(SHA1)
	 */
	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the androidNotificationServer
	 */
	public AndroidNotificationServer getAndroidNotificationServer() {
		return androidNotificationServer;
	}

	/**
	 * @param androidNotificationServer
	 *            the androidNotificationServer to set
	 */
	@XmlElement
	public void setAndroidNotificationServer(
			AndroidNotificationServer androidNotificationServer) {
		this.androidNotificationServer = androidNotificationServer;
	}

	/**
	 * @return the clientHistory
	 */
	public ClientHistory getClientHistory() {
		return clientHistory;
	}

	/**
	 * @param clientHistory
	 *            the clientHistory to set
	 */
	@XmlElement
	public void setClientHistory(ClientHistory clientHistory) {
		this.clientHistory = clientHistory;
	}

	/**
	 * @return the showParticipation
	 */
	public ShowParticipation getShowParticipation() {
		return showParticipation;
	}

	/**
	 * @param showParticipation
	 *            the showParticipation to set
	 */
	@XmlElement
	public void setShowParticipation(ShowParticipation showParticipation) {
		this.showParticipation = showParticipation;
	}

	/* ==========================CONSTRUCTOR======================= */

	public Client() {

	}

	/* ====================HASHCODE,EQUALS,TOSTRING================= */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.domain.BaseEntity#hashCode()
	 */

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.domain.BaseEntity#equals()
	 */

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.domain.BaseEntity#toString()
	 */

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.domain.BaseEntity#toJson()
	 */
	@Override
	public String toJson() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this)
				.toString();
	}
}