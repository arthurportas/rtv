package com.realtv.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "dificultyLevel"))
@NamedQueries({ @NamedQuery(name = "Level.FIND_ALL", query = "select l from Level l") })
@XmlRootElement(name = "level")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Level extends BaseEntity implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Level.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	private int dificultyLevel;

	@NotNull
	private int timeAvailableToAnswer;

	@ManyToMany
	@JoinTable(name = "LEVEL_QUESTION", 
				joinColumns = { @JoinColumn(name = "questionID", referencedColumnName = "id") }, 
				inverseJoinColumns = { @JoinColumn(name = "levelId", referencedColumnName = "id") })
	private List<Question> questions;

	/* ==========================GETTERS/SETTERS======================= */

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public int getDificultyLevel() {
		return dificultyLevel;
	}

	@XmlElement
	public void setDificultyLevel(int dificultyLevel) {
		this.dificultyLevel = dificultyLevel;
	}

	public int getTimeAvailableToAnswer() {
		return timeAvailableToAnswer;
	}

	@XmlElement
	public void setTimeAvailableToAnswer(int timeAvailableToAnswer) {
		this.timeAvailableToAnswer = timeAvailableToAnswer;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}
	
	@XmlElement
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	/* ==========================CONSTRUCTOR======================= */

	public Level() {

	}

	/* ====================HASHCODE,EQUALS,TOSTRING================= */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.domain.BaseEntity#hashCode()
	 */
	@Override
	public int hashCode() {
		return com.google.common.base.Objects.hashCode(this.dificultyLevel,
				this.timeAvailableToAnswer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.domain.BaseEntity#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Level other = (Level) obj;

		return com.google.common.base.Objects.equal(this.timeAvailableToAnswer,
				other.timeAvailableToAnswer)
				&& com.google.common.base.Objects.equal(this.dificultyLevel,
						other.dificultyLevel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.domain.BaseEntity#toString()
	 */
	@Override
	public String toString() {
		return com.google.common.base.Objects.toStringHelper(this)
				.addValue(this.dificultyLevel)
				.addValue(this.timeAvailableToAnswer).toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.domain.BaseEntity#toJson()
	 */
	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return null;
	}

}