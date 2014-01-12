package com.realtv.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.GsonBuilder;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "ShowType.FIND_ALL", query = "select st from ShowType st") })
@XmlRootElement(name = "showType")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ShowType extends BaseEntity implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "ShowType.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	private int mode = 0;/*'0-Jogo em modo DEMO\\n1-Jogo em modo RealTime'*/
	
	@NotNull
	@Size(min = 1, max = 255)
	// @Pattern(regexp = "[A-Za-z ]*", message =
	// "must contain only letters and spaces")
	private String description = StringUtils.EMPTY;

	@OneToMany(mappedBy = "showType")
	private List<Show> shows = Collections.emptyList();
	
	/* ==========================GETTERS/SETTERS======================= */

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public int getMode() {
		return mode;
	}

	@XmlElement
	public void setMode(int mode) {
		this.mode = mode;
	}
	
	
	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String name) {
		this.description = name;
	}

	public List<Show> getShows() {
		return shows;
	}
	
	@XmlElement
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	/* ==========================CONSTRUCTOR======================= */

	public ShowType() {

	}

	/* ====================HASHCODE,EQUALS,TOSTRING================= */
	/**
	 * Uses Guava to assist in providing hash code of this answer instance.
	 * 
	 * @return My hash code.
	 */

	@Override
	public int hashCode() {
		return com.google.common.base.Objects.hashCode(this.description,
				this.mode, this.shows);
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
		final ShowType other = (ShowType) obj;

		return com.google.common.base.Objects.equal(this.description, other.description)
				&& com.google.common.base.Objects.equal(this.mode,
						other.mode);
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
				.addValue(this.mode).addValue(this.description)
				.toString();
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