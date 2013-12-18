package com.realtv.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "answer"))
public class Answer implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
//	@Column(name="ANSWER_ID")
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "questionId")
	private Question question;

	/*==========================GETTERS/SETTERS=======================*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the correctAnswer
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * @param correctAnswer
	 *            the correctAnswer to set
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	/*==========================CONSTRUCTOR=======================*/

	public Answer() {

	}
	/*====================HASHCODE,EQUALS,TOSTRING=================*/
	
}