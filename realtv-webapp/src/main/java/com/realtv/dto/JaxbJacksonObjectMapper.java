/**
 * 
 */
package com.realtv.dto;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

/**
 * @author Arthur Portas
 * @date 25/01/2014
 */
public class JaxbJacksonObjectMapper extends ObjectMapper {

	public JaxbJacksonObjectMapper() {
		final AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
		super.getDeserializationConfig()
				.setAnnotationIntrospector(introspector);
		super.getSerializationConfig().setAnnotationIntrospector(introspector);
	}
}
