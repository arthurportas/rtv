package com.realtv.domain;

import java.io.Serializable;
import java.util.Collections;
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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.google.gson.GsonBuilder;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "question"))
@NamedQueries({
		@NamedQuery(name = "Question.FIND_ALL", query = "select q from Question q"),
		@NamedQuery(name = "Question.FIND_BY_QUESTION", query = "select q from Question q where q.question = :question"),
		@NamedQuery(name = "Question.FIND_ANSWERS_BY_QUESTION", query = "select q from Question q where q.question = :question") })
@XmlRootElement(name = "question")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Question extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Question.FIND_ALL";
	public static final String FIND_BY_QUESTION = "Question.FIND_BY_QUESTION";
	public static final String FIND_ANSWERS_BY_QUESTION = "Question.FIND_ANSWERS_BY_QUESTION";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Size(min = 1, max = 255)
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "must contain only letters, numbers and spaces")
	private String question = StringUtils.EMPTY;

	@OneToMany(mappedBy = "question")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Answer> answers = Collections.emptyList();

	@ManyToOne
	@JoinColumn(name = "themeId")
	private Theme theme;

	@ManyToOne
	@JoinColumn(name = "questionLevelId")
	private QuestionLevel questionLevel;

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

	public Theme getTheme() {
		return theme;
	}

	@XmlElement
	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public QuestionLevel getQuestionLevel() {
		return questionLevel;
	}

	@XmlElement
	public void setQuestionLevel(QuestionLevel questionLevel) {
		this.questionLevel = questionLevel;
	}

	/* ==========================CONSTRUCTOR======================= */

	public Question() {

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