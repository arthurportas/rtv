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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.GsonBuilder;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "answer"))
@NamedQueries({ @NamedQuery(name = "Answer.FIND_ALL", query = "select a from Answer a") })
@XmlRootElement(name = "aswer")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Answer extends BaseEntity implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Answer.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Size(min = 1, max = 255)
	// @Pattern(regexp = "[A-Za-z ]*", message =
	// "must contain only letters and spaces")
	private String answer;

	@NotNull
	@Size(min = 1, max = 255)
	// @Pattern(regexp = "[A-Za-z ]*", message =
	// "must contain only letters and spaces")
	private String correctAnswer;

	@ManyToOne
	@JoinColumn(name = "questionId")
	private Question question;

	/* ==========================GETTERS/SETTERS======================= */

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	@XmlElement
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	@XmlElement
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Question getQuestion() {
		return question;
	}

	@XmlElement
	public void setQuestion(Question question) {
		this.question = question;
	}

	/* ==========================CONSTRUCTOR======================= */

	public Answer() {

	}

	/* ====================HASHCODE,EQUALS,TOSTRING================= */
	/**
	 * Uses Guava to assist in providing hash code of this answer instance.
	 * 
	 * @return My hash code.
	 */

	@Override
	public int hashCode() {
		return com.google.common.base.Objects.hashCode(this.answer,
				this.correctAnswer);
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
		final Answer other = (Answer) obj;

		return com.google.common.base.Objects.equal(this.answer, other.answer)
				&& com.google.common.base.Objects.equal(this.correctAnswer,
						other.answer);
	}

	/**
	 * Method using Guava to provide String representation of this answer
	 * instance.
	 * 
	 * @return My String representation.
	 */

	@Override
	public String toString() {
		return this.answer + this.correctAnswer;
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