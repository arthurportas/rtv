package com.realtv.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.GsonBuilder;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "ClientHistory.FIND_ALL", query = "select ch from ClientHistory ch") })
@XmlRootElement(name = "clientHistory")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ClientHistory extends BaseEntity implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "ClientHistory.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private long timeSpentPlaying;

	@Digits(fraction = 0, integer = 6)
	private int numRightanswers;

	@Digits(fraction = 0, integer = 6)
	private int numWrongAnswers;

	@Digits(fraction = 0, integer = 6)
	private int numGamesCompleted;

	/* relation to Client */
	@OneToMany(mappedBy = "clientHistory")
	private List<Client> clients;

	/* relation to Show */
	@ManyToOne
	@JoinColumn(name = "showId")
	private Show show;

	/* ==========================GETTERS/SETTERS======================= */

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public long getTimeSpentPlaying() {
		return timeSpentPlaying;
	}

	@XmlElement
	public void setTimeSpentPlaying(long timeSpentPlaying) {
		this.timeSpentPlaying = timeSpentPlaying;
	}

	public int getNumRightanswers() {
		return numRightanswers;
	}

	@XmlElement
	public void setNumRightanswers(int numRightanswers) {
		this.numRightanswers = numRightanswers;
	}

	public int getNumWrongAnswers() {
		return numWrongAnswers;
	}

	@XmlElement
	public void setNumWrongAnswers(int numWrongAnswers) {
		this.numWrongAnswers = numWrongAnswers;
	}

	public int getNumGamesCompleted() {
		return numGamesCompleted;
	}

	@XmlElement
	public void setNumGamesCompleted(int numGamesCompleted) {
		this.numGamesCompleted = numGamesCompleted;
	}

	/**
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients
	 *            the clients to set
	 */
	@XmlElement
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the show
	 */
	public Show getShow() {
		return show;
	}

	/**
	 * @param show the show to set
	 */
	@XmlElement
	public void setShow(Show show) {
		this.show = show;
	}
	
	/* ==========================CONSTRUCTOR======================= */

	public ClientHistory() {

	}

	/* ====================HASHCODE,EQUALS,TOSTRING================= */
	/**
	 * Uses Guava to assist in providing hash code of this answer instance.
	 * 
	 * @return My hash code.
	 */

	@Override
	public int hashCode() {
		return com.google.common.base.Objects.hashCode(this.id);
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
		final ClientHistory other = (ClientHistory) obj;

		return com.google.common.base.Objects.equal(this.id, other.id);
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
				.addValue(this.id).toString();
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