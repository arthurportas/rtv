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

import com.google.gson.GsonBuilder;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "answer"))
@NamedQueries({ @NamedQuery(name = "Answer.FIND_ALL", query = "select a from Answer a") })
@XmlRootElement(name = "aswer")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Answer extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Answer.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Size(min = 1, max = 255)
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "must contain only letters, numbers and spaces")
	private String answer = StringUtils.EMPTY;

	@NotNull
	@Size(min = 1, max = 255)
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "must contain only letters, numbers and spaces")
	private String correctAnswer = StringUtils.EMPTY;

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
	 * @return My hash code.
	 */

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/**
	 * @param obj
	 *            Object to be compared to me for equality.
	 * @return {@code true} if provided object is considered equal to me or
	 *         {@code false} if provided object is not considered equal to me.
	 */

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * @return My String representation.
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