package com.constantcontact.components;

import java.io.Serializable;
import java.util.List;

import com.constantcontact.components.generic.response.ResultSet;
import com.constantcontact.exceptions.component.ConstantContactComponentException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * Base class for all components in Constant Contact.<br/>
 * Implements basic operations, common to all classes extending Component.
 * 
 * @author ConstantContact
 * 
 */
public abstract class Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -2551086630319838747L;

	/**
	 * Get list of objects from a JSON String.
	 * 
	 * @param json The JSON string.
	 * @param objClass Class type to be deserialized.
	 * @return Returns The list of objects deserialized from the JSON string.
	 * @throws ConstantContactComponentException When conversion crashes.
	 */
	public static <T> List<T> listFromJSON(String json, Class<T> objClass) throws ConstantContactComponentException {
		List<T> obj = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeFactory typeFactory = mapper.getTypeFactory();
			CollectionType collectionType = typeFactory.constructCollectionType(List.class, objClass);
			obj = mapper.readValue(json.getBytes("UTF-8"), collectionType);
		} catch (Exception e) {
			throw new ConstantContactComponentException("Exception while converting list from JSON", e);
		}
		return obj;
	}

	/**
	 * Get an object from a JSON String.
	 * 
	 * @param json The JSON string.
	 * @param objClass Class type to be deserialized.
	 * @return Returns the object deserialized from the JSON string.
	 * @throws ConstantContactComponentException When conversion crashes.
	 */
	public static <T> T fromJSON(String json, Class<T> objClass) throws ConstantContactComponentException {
		T obj = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			obj = mapper.readValue(json, objClass);
		} catch (Exception e) {
			throw new ConstantContactComponentException("Exception while converting object from JSON", e);
		}
		return obj;
	}

	/**
	 * Gets a {@link ResultSet} from a JSON String.
	 * 
	 * @param json The JSON representation to be converted
	 * @param objClass The type of entities which will be stored in the {@link ResultSet}
	 * @return The {@link ResultSet} resulted from the JSON
	 * @throws ConstantContactComponentException When conversion crashes.
	 */
	public static <T> ResultSet<T> resultSetFromJSON(String json, Class<T> objClass) throws ConstantContactComponentException {
		ResultSet<T> obj = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			TypeFactory typeFactory = mapper.getTypeFactory();
			JavaType javaType = typeFactory.constructParametricType(ResultSet.class, objClass);
			obj = mapper.readValue(json.getBytes("UTF-8"), javaType);
		} catch (Exception e) {
			throw new ConstantContactComponentException("Exception while converting from JSON", e);
		}
		return obj;
	}

	/**
	 * Serialize the current component to JSON.
	 * 
	 * @return Returns a {@link String} representing the serialized object.
	 * @throws ConstantContactComponentException When conversion crashes.
	 */
	public String toJSON() throws ConstantContactComponentException {
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			json = mapper.writeValueAsString(this);
		} catch (Exception e) {
			throw new ConstantContactComponentException("Exception while converting to JSON", e);
		}
		return json;
	}

	/**
	 * Default constructor.
	 */
	public Component() {
		super();
	}
}
