package com.constantcontact.components.activities.contacts.request;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.constantcontact.services.activities.BulkActivitiesService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An Address entry for the {@link ContactData} used in the Bulk Activities in Constant Contact.
 * 
 * @author ConstantContact
 * 
 * @see BulkActivitiesService
 * 
 */
public class Address extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -797931740547310641L;

	/**
	 * Line 1
	 */
	@JsonIgnore
	private String line1;

	/**
	 * Line 2
	 */
	@JsonIgnore
	private String line2;

	/**
	 * Line 3
	 */
	@JsonIgnore
	private String line3;

	/**
	 * City
	 */
	@JsonIgnore
	private String city;

	/**
	 * Address Type
	 */
	@JsonIgnore
	private String addressType;

	/**
	 * State Code
	 */
	@JsonIgnore
	private String stateCode;

	/**
	 * Country Code
	 */
	@JsonIgnore
	private String countryCode;

	/**
	 * Postal Code
	 */
	@JsonIgnore
	private String postalCode;

	/**
	 * Get Line 1
	 * 
	 * @return The {@link #line1}
	 */
	@JsonProperty("line1")
	public String getLine1() {
		return line1;
	}

	/**
	 * Get Line 2
	 * 
	 * @return The {@link #line2}
	 */
	@JsonProperty("line2")
	public String getLine2() {
		return line2;
	}

	/**
	 * Get Line 3
	 * 
	 * @return The {@link #line3}
	 */
	@JsonProperty("line3")
	public String getLine3() {
		return line3;
	}

	/**
	 * Get the city.
	 * 
	 * @return The {@link #city}
	 */
	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	/**
	 * Get the address type.
	 * 
	 * @return The {@link #addressType}
	 */
	@JsonProperty("address_type")
	public String getAddressType() {
		return addressType;
	}

	/**
	 * Get the state code.
	 * 
	 * @return The {@link #stateCode}
	 */
	@JsonProperty("state_code")
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * Get the country code.
	 * 
	 * @return The {@link #countryCode}
	 */
	@JsonProperty("country_code")
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Get the postal code.
	 * 
	 * @return The {@link #postalCode}
	 */
	@JsonProperty("postal_code")
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Set line 1
	 * 
	 * @param line1 New value for {@link #line1}
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}

	/**
	 * Set line 2
	 * 
	 * @param line2 New value for {@link #line2}
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}

	/**
	 * Set line 3
	 * 
	 * @param line3 New value for {@link #line3}
	 */
	public void setLine3(String line3) {
		this.line3 = line3;
	}

	/**
	 * Set city
	 * 
	 * @param city New value for {@link #city}
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Set address type
	 * 
	 * @param addressType New value for {@link #addressType}
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 * Set State Code
	 * 
	 * @param stateCode New value for {@link #stateCode}
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * Set Country Code
	 * 
	 * @param countryCode New value for {@link #countryCode}
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Set Postal Code
	 * 
	 * @param postalCode New value for {@link #postalCode}
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Default constructor.
	 */
	public Address() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [line1=");
		builder.append(line1);
		builder.append(", line2=");
		builder.append(line2);
		builder.append(", line3=");
		builder.append(line3);
		builder.append(", city=");
		builder.append(city);
		builder.append(", addressType=");
		builder.append(addressType);
		builder.append(", stateCode=");
		builder.append(stateCode);
		builder.append(", countryCode=");
		builder.append(countryCode);
		builder.append(", postalCode=");
		builder.append(postalCode);
		builder.append("]");
		return builder.toString();
	}
}
