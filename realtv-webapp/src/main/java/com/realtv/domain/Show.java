package com.realtv.domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Show.FIND_ALL", query = "select s from Show s") })
@XmlRootElement(name = "show")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Show extends BaseEntity implements Serializable {
	/** Default value included to remove warning. Remove or modify at will. **/
	private static final long serialVersionUID = 1L;

	public static final String FIND_ALL = "Show.FIND_ALL";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Size(min = 1, max = 255)
	// @Pattern(regexp = "[A-Za-z ]*", message =
	// "must contain only letters and spaces")
	private String name;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	/* e.g. 2010-12-31 23:59:59-Calendar.getInstance() */
	private Date beginning;

	@Future
	@Temporal(TemporalType.TIMESTAMP)
	private Date ending;

	/* relationship to ShowType */
	@ManyToOne
	@JoinColumn(name = "showTypeId")
	private ShowType showType;

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

	/* ==========================CONSTRUCTOR======================= */

	public Show() {

	}

	/* ====================HASHCODE,EQUALS,TOSTRING================= */
	/**
	 * Uses Guava to assist in providing hash code of this answer instance.
	 * 
	 * @return My hash code.
	 */

	@Override
	public int hashCode() {
		return com.google.common.base.Objects.hashCode(this.name,
				this.beginning, this.ending);
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
		final Show other = (Show) obj;

		return com.google.common.base.Objects.equal(this.name, other.name)
				&& com.google.common.base.Objects.equal(this.beginning,
						other.beginning)
				&& com.google.common.base.Objects.equal(this.ending,
						other.ending);
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
				.addValue(this.name).addValue(this.beginning)
				.addValue(this.ending).toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.realtv.domain.BaseEntity#toJson()
	 */
	@Override
	public String toJson() {
		/* needs refactor */
		/*
		 * ObjectMapper mapper = new ObjectMapper(); AnnotationIntrospector
		 * introspector = new JacksonAnnotationIntrospector();
		 * mapper.setAnnotationIntrospector(introspector); String result = null;
		 * try { result = mapper.writeValueAsString(this); } catch
		 * (JsonGenerationException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (JsonMappingException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * System.out.println(result); return result;
		 */
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this).toString();

	}
}