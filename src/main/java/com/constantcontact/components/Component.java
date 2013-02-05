package com.constantcontact.components;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * Base class for components.
 * 
 * @author ConstantContact
 *
 */
public abstract class Component implements Serializable {
	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -6549082824239498493L;
	
	/**
	 * Get list of objects from JSON.
	 * @param json The serialization string.
	 * @param objClass Class type to be deserialized.
	 * @return Returns the list of objects deserialized from the JSON string.
	 */
	public static <T> List<T> listFromJSON(String json, Class<T> objClass) {
		List<T> obj = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeFactory typeFactory = mapper.getTypeFactory();
			CollectionType collectionType = typeFactory.constructCollectionType(List.class, objClass);
			obj = mapper.readValue(json.getBytes("UTF-8"), collectionType);
		} catch (Exception e) {
			throw new IllegalStateException("exception happend while converting json", e);
		}
		return obj;
	}
	
	/**
	 * Get object from JSON.
	 * @param json The serialization string.
	 * @param objClass Class type to be deserialized.
	 * @return Returns object deserialized from the JSON string.
	 */
	public static <T> T fromJSON(String json, Class<T> objClass) {
		T obj = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			obj = mapper.readValue(json, objClass);
		} catch (Exception e) {
			throw new IllegalStateException("exception happend while converting json", e);
		}
		return obj;
	}
	
	/**
	 * Serialize an object to JSON.
	 * @return Returns a string representing the serialized object.
	 */
	public String toJSON() {
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(this);
		} catch (Exception e) {
			throw new IllegalStateException("exception happend while converting json", e);
		}
		return json;
	}
}
