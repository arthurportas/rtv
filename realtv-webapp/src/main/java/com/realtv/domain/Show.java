package com.realtv.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
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
@NamedQueries({ @NamedQuery(name = "Show.FIND_ALL", query = "select s from Show s") })
@XmlRootElement(name = "show")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Show extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Show.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Size(min = 1, max = 255)
	@Pattern(regexp = "[A-Za-z0-9 ]*", message = "must contain only letters, numbers and spaces")
	private String name = StringUtils.EMPTY;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	/* e.g. 2010-12-31 23:59:59-Calendar.getInstance() */
	private Date beginning = Calendar.getInstance().getTime();

	@Future
	@Temporal(TemporalType.TIMESTAMP)
	private Date ending;

	/* relationship to ShowType */
	@ManyToOne
	@JoinColumn(name = "showTypeId")
	private ShowType showType;
	
	/* relation to ClientHistory REFACTOR TO CLIENT??*/
	@OneToMany(mappedBy = "show")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ClientHistory> clientsHistory = Collections.emptyList();
	
	@OneToMany(mappedBy = "show")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ShowParticipation> showsParticipation = Collections.emptyList();
	
	/* ==========================GETTERS/SETTERS======================= */

	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public Date getBeginning() {
		return beginning;
	}

	@XmlElement
	public void setBeginning(Date beginning) {
		this.beginning = beginning;
	}

	public Date getEnding() {
		return ending;
	}

	@XmlElement
	public void setEnding(Date ending) {
		this.ending = ending;
	}

	public ShowType getShowType() {
		return showType;
	}

	@XmlElement
	public void setShowType(ShowType showType) {
		this.showType = showType;
	}
	
	/**
	 * @return the clientsHistory
	 */
	public List<ClientHistory> getClientsHistory() {
		return clientsHistory;
	}

	/**
	 * @param clientsHistory the clientsHistory to set
	 */
	@XmlElement
	public void setClientsHistory(List<ClientHistory> clientsHistory) {
		this.clientsHistory = clientsHistory;
	}
	
	/**
	 * @return the showsParticipation
	 */
	public List<ShowParticipation> getShowsParticipation() {
		return showsParticipation;
	}

	/**
	 * @param showsParticipation the showsParticipation to set
	 */
	@XmlElement
	public void setShowsParticipation(List<ShowParticipation> showsParticipation) {
		this.showsParticipation = showsParticipation;
	}

	/* ==========================CONSTRUCTOR======================= */

	public Show() {

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