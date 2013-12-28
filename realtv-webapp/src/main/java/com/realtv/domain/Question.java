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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.ImmutableList;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "question"))
@NamedQueries({
		@NamedQuery(name = "Question.FIND_ALL", query = "select q from Question q"),
		@NamedQuery(name = "Question.FIND_BY_QUESTION", query = "select q from Question q where q.question = :question"),
		@NamedQuery(name = "Question.FIND_ANSWERS_BY_QUESTION", query = "select q from Question q where q.question = :question") 
		})
@XmlRootElement(name="question")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Question extends BaseEntity implements Serializable {

	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Question.FIND_ALL";
	public static final String FIND_BY_QUESTION = "Question.FIND_BY_QUESTION";
	public static final String FIND_ANSWERS_BY_QUESTION = "Question.FIND_ANSWERS_BY_QUESTION";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Size(min = 1, max = 255)
	// @Pattern(regexp = "[A-Za-z ]*", message =
	// "must contain only letters and spaces")
	private String question;

	@OneToMany(mappedBy = "question")
	private List<Answer> answers;

	@ManyToOne
	@JoinColumn(name = "themeId")
	private Theme theme;
	
	/* ==========================GETTERS/SETTERS======================= */

	public Long getId() {
		return id;
	}
	
	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	@XmlElement
	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	@XmlElement
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	@XmlElement
	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Theme getTheme() {
		return theme;
	}

	/* ==========================CONSTRUCTOR======================= */

	public Question() {

	}

	/* ====================HASHCODE,EQUALS,TOSTRING================= */
	/**
	 * Uses Guava to assist in providing hash code of this question instance.
	 * 
	 * @return My hash code.
	 */
	 
	@Override
	public int hashCode() {
		return com.google.common.base.Objects.hashCode(this.question,
				this.answers,this.theme);
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
		final Question other = (Question) obj;

		return com.google.common.base.Objects.equal(this.question,
				other.question)
				&& com.google.common.base.Objects.equal(
						ImmutableList.copyOf(this.answers),
						(ImmutableList.copyOf(other.answers)))
						&& com.google.common.base.Objects.equal(this.theme, other.theme);
	}

	/**
	 * Method using Guava to provide String representation of this question
	 * instance.
	 * 
	 * @return My String representation.
	 */
	 
	@Override
	public String toString() {
		return com.google.common.base.Objects.toStringHelper(this)
				.addValue(this.question).addValue(this.answers).addValue(this.theme)
				.toString();
	}

	/* (non-Javadoc)
	 * @see com.realtv.domain.BaseEntity#toJson()
	 */
	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return null;
	}
}