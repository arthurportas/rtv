package com.realtv.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "theme"))
@XmlRootElement(name="question")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Theme extends BaseEntity implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Size(min = 1, max = 255)
	// @Pattern(regexp = "[A-Za-z ]*", message =
	// "must contain only letters and spaces")
	private String theme;

	@NotNull
	@Size(min = 1, max = 255)
	// @Pattern(regexp = "[A-Za-z ]*", message =
	// "must contain only letters and spaces")
	private String name;

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "questionId")
	private Question question;*/

	/*==========================GETTERS/SETTERS=======================*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}*/
	
	/*==========================CONSTRUCTOR=======================*/

	public Theme() {

	}
	/*====================HASHCODE,EQUALS,TOSTRING=================*/

	/* (non-Javadoc)
	 * @see com.realtv.domain.BaseEntity#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.realtv.domain.BaseEntity#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.realtv.domain.BaseEntity#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
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