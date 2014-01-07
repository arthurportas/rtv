package com.realtv.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.GsonBuilder;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "ShowParticipation.FIND_ALL", query = "select sp from ShowParticipation sp") })
@XmlRootElement(name = "showParticipation")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ShowParticipation extends BaseEntity implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "ShowParticipation.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	/* e.g. 2010-12-31 23:59:59-Calendar.getInstance() */
	private Date lastBeginPlaying;

	@Future
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastEndPlaying;

	private long timeSpentPlaying;
	
	private int numGamesCompleted;
	
	private int numRightAnswers;
	
	private int numWrongAnswers;
	
	/*relation to Show*/
	@ManyToOne
	@JoinColumn(name = "showId")
	private Show show;
	
	/*relation to Client*/
	@OneToMany(mappedBy = "showParticipation")
	private List<Client> clients;
	
	/* ==========================GETTERS/SETTERS======================= */

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the lastBeginPlaying
	 */
	public Date getLastBeginPlaying() {
		return lastBeginPlaying;
	}

	/**
	 * @param lastBeginPlaying the lastBeginPlaying to set
	 */
	public void setLastBeginPlaying(Date lastBeginPlaying) {
		this.lastBeginPlaying = lastBeginPlaying;
	}

	/**
	 * @return the lastEndPlaying
	 */
	public Date getLastEndPlaying() {
		return lastEndPlaying;
	}

	/**
	 * @param lastEndPlaying the lastEndPlaying to set
	 */
	public void setLastEndPlaying(Date lastEndPlaying) {
		this.lastEndPlaying = lastEndPlaying;
	}

	/**
	 * @return the timeSpentPlaying
	 */
	public long getTimeSpentPlaying() {
		return timeSpentPlaying;
	}

	/**
	 * @param timeSpentPlaying the timeSpentPlaying to set
	 */
	public void setTimeSpentPlaying(long timeSpentPlaying) {
		this.timeSpentPlaying = timeSpentPlaying;
	}

	/**
	 * @return the numGamesCompleted
	 */
	public int getNumGamesCompleted() {
		return numGamesCompleted;
	}

	/**
	 * @param numGamesCompleted the numGamesCompleted to set
	 */
	public void setNumGamesCompleted(int numGamesCompleted) {
		this.numGamesCompleted = numGamesCompleted;
	}

	/**
	 * @return the numRightAnswers
	 */
	public int getNumRightAnswers() {
		return numRightAnswers;
	}

	/**
	 * @param numRightAnswers the numRightAnswers to set
	 */
	public void setNumRightAnswers(int numRightAnswers) {
		this.numRightAnswers = numRightAnswers;
	}

	/**
	 * @return the numWrongAnswers
	 */
	public int getNumWrongAnswers() {
		return numWrongAnswers;
	}

	/**
	 * @param numWrongAnswers the numWrongAnswers to set
	 */
	public void setNumWrongAnswers(int numWrongAnswers) {
		this.numWrongAnswers = numWrongAnswers;
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
	public void setShow(Show show) {
		this.show = show;
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
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	/* ==========================CONSTRUCTOR======================= */

	public ShowParticipation() {

	}

	/* ====================HASHCODE,EQUALS,TOSTRING================= */
	/**
	 * Uses Guava to assist in providing hash code of this answer instance.
	 * 
	 * @return My hash code.
	 */

	@Override
	public int hashCode() {
		return com.google.common.base.Objects.hashCode(this.id,
				this.lastBeginPlaying, this.lastEndPlaying);
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
		final ShowParticipation other = (ShowParticipation) obj;

		return com.google.common.base.Objects.equal(this.lastBeginPlaying, other.lastBeginPlaying)
				&& com.google.common.base.Objects.equal(this.lastEndPlaying,
						other.lastEndPlaying)
				&& com.google.common.base.Objects.equal(this.numGamesCompleted,
						other.numGamesCompleted);
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
				.addValue(this.numGamesCompleted).addValue(this.numRightAnswers)
				.addValue(this.numWrongAnswers).toString();
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