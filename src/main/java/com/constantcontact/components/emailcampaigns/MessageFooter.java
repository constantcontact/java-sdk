package com.constantcontact.components.emailcampaigns;

import java.io.Serializable;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Message Footer from an {@link EmailCampaignBase} for the Email Campaign Service in Constant Contact.<br/>
 * 
 * @author ConstantContact
 */
public class MessageFooter extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -3858441772355624343L;

	@JsonIgnore
	private String city;
	@JsonIgnore
	private String state;
	@JsonIgnore
	private String country;
	@JsonIgnore
	private String organizationName;
	@JsonIgnore
	private String addressLine1;
	@JsonIgnore
	private String addressLine2;
	@JsonIgnore
	private String addressLine3;
	@JsonIgnore
	private String internationalState;
	@JsonIgnore
	private String postalCode;
	@JsonIgnore
	private boolean includeForwardEmail;
	@JsonIgnore
	private String forwardEmailLinkText;
	@JsonIgnore
	private boolean includeSubscribeLink;
	@JsonIgnore
	private String subscribeLinkText;

	/**
	 * Get the City
	 * 
	 * @return The City
	 */
	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	/**
	 * Get the State
	 * 
	 * @return The State
	 */
	@JsonProperty("state")
	public String getState() {
		return state;
	}

	/**
	 * Get the Country
	 * 
	 * @return The Country
	 */
	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	/**
	 * Get the Organization Name
	 * 
	 * @return The Organization Name
	 */
	@JsonProperty("organization_name")
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * Get the Address Line 1
	 * 
	 * @return The Address Line 1
	 */
	@JsonProperty("address_line_1")
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * Get the Address Line 2
	 * 
	 * @return The Address Line 2
	 */
	@JsonProperty("address_line_2")
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * Get the Address Line 3
	 * 
	 * @return The Address Line 3
	 */
	@JsonProperty("address_line_3")
	public String getAddressLine3() {
		return addressLine3;
	}

	/**
	 * Get the International State
	 * 
	 * @return The International State
	 */
	@JsonProperty("international_state")
	public String getInternationalState() {
		return internationalState;
	}

	/**
	 * Get the Postal Code
	 * 
	 * @return The Postal Code
	 */
	@JsonProperty("postal_code")
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Get the Include Forward Email flag
	 * 
	 * @return The Include Forward Email flag
	 */
	@JsonProperty("include_forward_email")
	public boolean isIncludeForwardEmail() {
		return includeForwardEmail;
	}

	/**
	 * Get the Forward Email Link Text
	 * 
	 * @return The Forward Email Link Text
	 */
	@JsonProperty("forward_email_link_text")
	public String getForwardEmailLinkText() {
		return forwardEmailLinkText;
	}

	/**
	 * Get the Include Subscribe Link flag
	 * 
	 * @return The Include Subscribe Link flag
	 */
	@JsonProperty("include_subscribe_link")
	public boolean isIncludeSubscribeLink() {
		return includeSubscribeLink;
	}

	/**
	 * Get the Subscribe Link Text
	 * 
	 * @return The Subscribe Link Text
	 */
	@JsonProperty("subscribe_link_text")
	public String getSubscribeLinkText() {
		return subscribeLinkText;
	}

	/**
	 * Set the City
	 * 
	 * @param city The City
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Set the State
	 * 
	 * @param state The State
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Set the Country
	 * 
	 * @param country The Country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Set the Organization Name
	 * 
	 * @param organizationName The Organization Name
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * Set the Address Line 1
	 * 
	 * @param addressLine1 The Address Line 1
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * Set the Address Line 2
	 * 
	 * @param addressLine2 The Address Line 2
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * Set the Address Line 3
	 * 
	 * @param addressLine3 The Address Line 3
	 */
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	/**
	 * Set the International State
	 * 
	 * @param internationalState The International State
	 */
	public void setInternationalState(String internationalState) {
		this.internationalState = internationalState;
	}

	/**
	 * Set the Postal Code
	 * 
	 * @param postalCode The Postal Code
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * Set the Include Forward Email flag
	 * 
	 * @param includeForwardEmail The Include Forward Email flag
	 */
	public void setIncludeForwardEmail(boolean includeForwardEmail) {
		this.includeForwardEmail = includeForwardEmail;
	}

	/**
	 * Set the Forward Email Link Text
	 * 
	 * @param forwardEmailLinkText The Forward Email Link Text
	 */
	public void setForwardEmailLinkText(String forwardEmailLinkText) {
		this.forwardEmailLinkText = forwardEmailLinkText;
	}

	/**
	 * Set the Include Subscribe Link flag
	 * 
	 * @param includeSubscribeLink The Include Subscribe Link flag
	 */
	public void setIncludeSubscribeLink(boolean includeSubscribeLink) {
		this.includeSubscribeLink = includeSubscribeLink;
	}

	/**
	 * Set the Subscribe Link Text
	 * 
	 * @param subscribeLinkText The Subscribe Link Text
	 */
	public void setSubscribeLinkText(String subscribeLinkText) {
		this.subscribeLinkText = subscribeLinkText;
	}

	/**
	 * Default constructor.
	 */
	public MessageFooter() {
		super();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageFooter [city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", country=");
		builder.append(country);
		builder.append(", organizationName=");
		builder.append(organizationName);
		builder.append(", addressLine1=");
		builder.append(addressLine1);
		builder.append(", addressLine2=");
		builder.append(addressLine2);
		builder.append(", addressLine3=");
		builder.append(addressLine3);
		builder.append(", internationalState=");
		builder.append(internationalState);
		builder.append(", postalCode=");
		builder.append(postalCode);
		builder.append(", includeForwardEmail=");
		builder.append(includeForwardEmail);
		builder.append(", forwardEmailLinkText=");
		builder.append(forwardEmailLinkText);
		builder.append(", includeSubscribeLink=");
		builder.append(includeSubscribeLink);
		builder.append(", subscribeLinkText=");
		builder.append(subscribeLinkText);
		builder.append("]");
		return builder.toString();
	}
}
