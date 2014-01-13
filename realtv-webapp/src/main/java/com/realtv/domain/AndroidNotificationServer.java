package com.realtv.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.GsonBuilder;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "GCMAuthorizationKey"))
@NamedQueries({ @NamedQuery(name = "AndroidNotificationServer.FIND_ALL", query = "select ans from AndroidNotificationServer ans") })
@XmlRootElement(name = "androidNotificationServer")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class AndroidNotificationServer extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "AndroidNotificationServer.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Value("${AndroidNotificationServer.GCMAuthorizationKey}")
	@Size(min = 1, max = 500)
	private String GCMAuthorizationKey;

	@NotNull
	@Email
	@Value("${AndroidNotificationServer.registeredEmail}")
	@Size(min = 1, max = 80)
	private String registeredEmail;

	@OneToMany(mappedBy = "androidNotificationServer")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Client> clients;
	
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
	 * @return GCMAuthorizationKey - GCM Google service
	 */
	public String getGCMAuthorizationKey() {
		return GCMAuthorizationKey;
	}

	/**
	 * @param GCMAuthorizationKey - the key to set - initialized from properties file
	 */
	@XmlElement
	public void setGCMAuthorizationKey(String GCMAuthorizationKey) {
		this.GCMAuthorizationKey = GCMAuthorizationKey;
	}

	/**
	 * @return registeredEmail
	 */
	public String getRegisteredEmail() {
		return registeredEmail;
	}

	/**
	 * @param registeredEmail - the email to set
	 */
	@XmlElement
	public void setRegisteredEmail(String registeredEmail) {
		this.registeredEmail = registeredEmail;
	}
	
	/**
	 * @return list of {@link Client}
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients - the {@link Client} list to set
	 */
	@XmlElement
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	/* ==========================CONSTRUCTOR======================= */

	public AndroidNotificationServer() {

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
		return new GsonBuilder().setPrettyPrinting().create().toJson(this).toString();
	}
}