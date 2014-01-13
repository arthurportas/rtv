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
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.google.gson.GsonBuilder;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "dificultyLevel"))
@NamedQueries({ @NamedQuery(name = "QuestionLevel.FIND_ALL", query = "select ql from QuestionLevel ql") })
@XmlRootElement(name = "questionLevel")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class QuestionLevel extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "QuestionLevel.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Digits(fraction = 0, integer = 1)
	private int dificultyLevel = 1;

	@NotNull
	@Digits(fraction = 0, integer = 2)
	private int timeAvailableToAnswer = 30;

	@OneToMany(mappedBy = "questionLevel")
	@LazyCollection(LazyCollectionOption.FALSE)
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

	public QuestionLevel() {

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
	 * @see com.realtv.domain.BaseEntity#equals(java.lang.Object)
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