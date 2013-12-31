package com.realtv.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
import com.google.gson.GsonBuilder;
/**
 * Represents an associated question theme.
 * Possible values are ()
 * */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "theme"))
@XmlRootElement(name = "theme")
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
	private String description;

	@OneToMany(mappedBy = "theme")
	private List<Question> questions;

	/* ==========================GETTERS/SETTERS======================= */

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	@XmlElement
	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	@XmlElement
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	/* ==========================CONSTRUCTOR======================= */

	public Theme() {

	}

	/* ====================HASHCODE,EQUALS,TOSTRING================= */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.domain.BaseEntity#hashCode()
	 */
	@Override
	public int hashCode() {
		return com.google.common.base.Objects.hashCode(this.theme, this.description,
				this.questions);
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
		final Theme other = (Theme) obj;

		return com.google.common.base.Objects.equal(this.theme, other.theme)
				&& com.google.common.base.Objects.equal(this.description, other.description)
				&& com.google.common.base.Objects.equal(
						ImmutableList.copyOf(this.questions),
						(ImmutableList.copyOf(other.questions)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.domain.BaseEntity#toString()
	 */
	@Override
	public String toString() {
		return com.google.common.base.Objects.toStringHelper(this)
				.addValue(this.theme).addValue(this.description)
				.addValue(this.questions).toString();
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