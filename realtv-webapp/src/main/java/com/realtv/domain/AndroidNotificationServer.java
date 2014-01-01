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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Email;

import com.google.gson.GsonBuilder;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "GCMAuthorizationKey"))
@NamedQueries({ @NamedQuery(name = "AndroidNotificationServer.FIND_ALL", query = "select ans from AndroidNotificationServer ans") })
@XmlRootElement(name = "androidNotificationServer")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class AndroidNotificationServer extends BaseEntity implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "AndroidNotificationServer.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	//TODO set default value from properties file
	@NotNull
	private String GCMAuthorizationKey;
	/*registado em https://code.google.com/apis/console/#project:549909978524 para envio de notificações*/

	@NotNull
	@Email
	private String registeredEmail;
	/*registeredEmail-email registado no GCM para envio de notificações narthurportas@gmail.com*/

	@OneToMany(mappedBy = "androidNotificationServer")
	private List<Client> clients;
	
	/* ==========================GETTERS/SETTERS======================= */

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getGCMAuthorizationKey() {
		return GCMAuthorizationKey;
	}

	@XmlElement
	public void setGCMAuthorizationKey(String GCMAuthorizationKey) {
		this.GCMAuthorizationKey = GCMAuthorizationKey;
	}

	public String getRegisteredEmail() {
		return registeredEmail;
	}

	@XmlElement
	public void setRegisteredEmail(String registeredEmail) {
		this.registeredEmail = registeredEmail;
	}
	
	/**
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	@XmlElement
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	/* ==========================CONSTRUCTOR======================= */

	

	public AndroidNotificationServer() {

	}

	/* ====================HASHCODE,EQUALS,TOSTRING================= */
	/**
	 * Uses Guava to assist in providing hash code of this answer instance.
	 * 
	 * @return My hash code.
	 */

	@Override
	public int hashCode() {
		return com.google.common.base.Objects.hashCode(this.GCMAuthorizationKey);
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
		final AndroidNotificationServer other = (AndroidNotificationServer) obj;

		return com.google.common.base.Objects.equal(this.GCMAuthorizationKey, other.GCMAuthorizationKey);
	}

	/**
	 * Method using Guava to provide String representation of this answer
	 * instance.
	 * 
	 * @return My String representation.
	 */

	@Override
	public String toString() {
		return com.google.common.base.Objects.toStringHelper(this).toString();
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