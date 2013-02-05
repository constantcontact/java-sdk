package com.constantcontact.components.contacts;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomField extends Component implements Serializable {
	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -2361521080992020447L;
	@JsonIgnore private String name;
	@JsonIgnore private String value;
	
	/**
	 * Gets the name of the custom field. Only accepted names.
	 * @return The name of the custom field.
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the custom field. Only accepted names.
	 * @param name The name of the custom field.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the value of the custom field.
	 * @return The value of the custom field.
	 */
	@JsonProperty("value")
	public String getValue() {
		return value;
	}
	
	/**
	 * Sets the value of the custom field.
	 * @param value The value of the custom field.
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Custom fields names constants.
	 */
	public static final class CustomFieldName {
		/**
		 * Custom field 1.
		 */
        public final static String CUSTOM_FIELD1 = "CustomField1";

        /**
         * Custom field 2.
         */
        public final static String CUSTOM_FIELD2 = "CustomField2";

        /**
         * Custom field 3.
         */
        public final static String CUSTOM_FIELD3 = "CustomField3";

        /**
         * Custom field 4.
         */
        public final static String CUSTOM_FIELD4 = "CustomField4";

        /**
         * Custom field 5.
         */
        public final static String CUSTOM_FIELD5 = "CustomField5";

        /**
         * Custom field 6.
         */
        public final static String CUSTOM_FIELD6 = "CustomField6";

        /**
         * Custom field 7.
         */
        public final static String CUSTOM_FIELD7 = "CustomField7";

        /**
         * Custom field 8.
         */
        public final static String CUSTOM_FIELD8 = "CustomField8";

        /**
         * Custom field 9.
         */
        public final static String CUSTOM_FIELD9 = "CustomField9";

        /**
         * Custom field 10.
         */
        public final static String CUSTOM_FIELD10 = "CustomField10";

        /**
         * Custom field 11.
         */
        public final static String CUSTOM_FIELD11 = "CustomField11";

        /**
         * Custom field 12.
         */
        public final static String CUSTOM_FIELD12 = "CustomField12";

        /**
         * Custom field 13.
         */
        public final static String CUSTOM_FIELD13 = "CustomField13";

        /**
         * Custom field 14.
         */
        public final static String CUSTOM_FIELD14 = "CustomField14";

        /**
         * Custom field 15.
         */
        public final static String CUSTOM_FIELD15 = "CustomField15";
	}
}
