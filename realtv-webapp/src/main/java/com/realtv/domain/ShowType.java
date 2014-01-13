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
@Table
@NamedQueries({ @NamedQuery(name = "ShowType.FIND_ALL", query = "select st from ShowType st") })
@XmlRootElement(name = "showType")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ShowType extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "ShowType.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	private int mode = 0;/*'0-Jogo em modo DEMO1-Jogo em modo RealTime'*/
	
	@NotNull
	@Size(min = 1, max = 255)
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "must contain only letters, numbers and spaces")
	private String description = StringUtils.EMPTY;

	@OneToMany(mappedBy = "showType")
	@LazyCollection(LazyCollectionOption.FALSE)
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
		return new GsonBuilder().setPrettyPrinting().create().toJson(this).toString();
	}
}