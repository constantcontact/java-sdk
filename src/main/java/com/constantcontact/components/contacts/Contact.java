package com.constantcontact.components.contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Contact for the Contact Service in Constant Contact.
 * 
 * @author ConstantContact
 * 
 */
public class Contact extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -1549895334676301738L;

	@JsonIgnore
	private String id;
	@JsonIgnore
	private String status;
	@JsonIgnore
	private String fax;
	@JsonIgnore
	private List<Address> addresses;
	@JsonIgnore
	private List<Note> notes;
	@JsonIgnore
	private boolean confirmed;
	@JsonIgnore
	private List<ContactList> lists;
	@JsonIgnore
	private String source;
	@JsonIgnore
	private List<EmailAddress> emailAddresses;
	@JsonIgnore
	private String prefixName;
	@JsonIgnore
	private String firstName;
	@JsonIgnore
	private String middleName;
	@JsonIgnore
	private String lastName;
	@JsonIgnore
	private String jobTitle;
	@JsonIgnore
	private String companyName;
	@JsonIgnore
	private List<CustomField> customFields;
	@JsonIgnore
	private String sourceDetails;
	@JsonIgnore
	private String workPhone;
	@JsonIgnore
	private String homePhone;
	@JsonIgnore
	private String cellPhone;
	@JsonIgnore
	private String createdDate;
	@JsonIgnore
	private String modifiedDate;
	/**
	 * Gets the id.
	 * 
	 * @return The id.
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id <code>Contact</code> id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the status.
	 * 
	 * @return The status.
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status The status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the fax number.
	 * 
	 * @return The fax number.
	 */
	@JsonProperty("fax")
	public String getFax() {
		return fax;
	}

	/**
	 * Sets the fax number.
	 * 
	 * @param fax The fax number.
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * Gets the addresses.
	 * 
	 * @return The addresses, as a list of {@link Address}.
	 */
	@JsonProperty("addresses")
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * Sets the addresses.
	 * 
	 * @param addresses The addresses.
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * Gets the notes.
	 * 
	 * @return The notes as a list of {@link Note}.
	 */
	@JsonProperty("notes")
	public List<Note> getNotes() {
		return notes;
	}

	/**
	 * Sets the notes.
	 * 
	 * @param notes The notes.
	 */
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	/**
	 * Gets the confirmation flag;
	 * 
	 * @return The confirmation flag.
	 */
	@JsonProperty("confirmed")
	public boolean isConfirmed() {
		return confirmed;
	}

	/**
	 * Sets the confirmation flag.
	 * 
	 * @param confirmed The confirmation flag.
	 */
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	/**
	 * Gets the Contact Lists.
	 * 
	 * @return The contact lists.
	 */
	@JsonProperty("lists")
	public List<ContactList> getLists() {
		return lists;
	}

	/**
	 * Sets the contact lists.
	 * 
	 * @param lists The contact lists.
	 */
	public void setLists(List<ContactList> lists) {
		this.lists = lists;
	}

	/**
	 * Gets the source.
	 * 
	 * @return The source.
	 */
	@JsonProperty("source")
	public String getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 * 
	 * @param source The source.
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * Gets the email addresses.
	 * 
	 * @return The email addresses, as a list of {@link EmailAddress}.
	 */
	@JsonProperty("email_addresses")
	public List<EmailAddress> getEmailAddresses() {
		return emailAddresses;
	}

	/**
	 * Sets the email addresses.
	 * 
	 * @param emailAddresses The email addresses.
	 */
	public void setEmailAddresses(List<EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	/**
	 * Gets the prefix name.<br/>
	 * Salutation (Mr., Ms., Sir, Mrs., Dr., etc)
	 * 
	 * @return The prefix name.
	 */
	@JsonProperty("prefix_name")
	public String getPrefixName() {
		return prefixName;
	}

	/**
	 * Sets the prefix name.<br/>
	 * Salutation (Mr., Ms., Sir, Mrs., Dr., etc)
	 * 
	 * @param prefixName The prefix name.
	 */
	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
	}

	/**
	 * Gets the createdDate.
	 * 
	 * @return The createdDate.
	 */
	@JsonProperty("created_date")
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the createdDate.
	 * 
	 * @param createdDate .
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the modifiedDate.
	 * 
	 * @return The modifiedDate.
	 */
	@JsonProperty("modified_date")
	public String getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Sets the modifiedDate.
	 * 
	 * @param modifiedDate The first name.
	 */
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	/**
	 * Gets the first name.
	 * 
	 * @return The first name.
	 */
	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 * 
	 * @param firstName The first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the middle name.
	 * 
	 * @return The middle name.
	 */
	@JsonProperty("middle_name")
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets the middle name.
	 * 
	 * @param middleName The middle name.
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Gets the last name.
	 * 
	 * @return The last name.
	 */
	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 * 
	 * @param lastName The last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the job title.
	 * 
	 * @return The job title.
	 */
	@JsonProperty("job_title")
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * Sets the job title.
	 * 
	 * @param jobTitle The job title.
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * Gets the company name.
	 * 
	 * @return The company name.
	 */
	@JsonProperty("company_name")
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Sets the company name.
	 * 
	 * @param companyName The company name.
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Gets the list of custom fields.
	 * 
	 * @return The list of {@link CustomField}.
	 */
	@JsonProperty("custom_fields")
	public List<CustomField> getCustomFields() {
		return customFields;
	}

	/**
	 * Sets the list of custom fields.
	 * 
	 * @param customFields The list of custom fields.
	 */
	public void setCustomFields(List<CustomField> customFields) {
		this.customFields = customFields;
	}

	/**
	 * Gets the source details.
	 * 
	 * @return The source details.
	 */
	@JsonProperty("source_details")
	public String getSourceDetails() {
		return sourceDetails;
	}

	/**
	 * Sets the source details.
	 * 
	 * @param sourceDetails The source details.
	 */
	public void setSourceDetails(String sourceDetails) {
		this.sourceDetails = sourceDetails;
	}

	/**
	 * Gets the work phone.
	 * 
	 * @return The work phone.
	 */
	@JsonProperty("work_phone")
	public String getWorkPhone() {
		return workPhone;
	}

	/**
	 * Sets the work phone.
	 * 
	 * @param workPhone The work phone.
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	/**
	 * Gets the home phone.
	 * 
	 * @return The home phone.
	 */
	@JsonProperty("home_phone")
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * Sets the home phone.
	 * 
	 * @param homePhone The home phone.
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * Gets the cell phone.
	 * 
	 * @return The cell phone.
	 */
	@JsonProperty("cell_phone")
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * Sets the cell phone.
	 * 
	 * @param cellPhone The cell phone.
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * Default constructor.
	 */
	public Contact() {
		this.emailAddresses = new ArrayList<EmailAddress>();
		this.addresses = new ArrayList<Address>();
		this.customFields = new ArrayList<CustomField>();
		this.lists = new ArrayList<ContactList>();
		this.notes = new ArrayList<Note>();
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [id=");
		builder.append(id);
		builder.append(", status=");
		builder.append(status);
		builder.append(", fax=");
		builder.append(fax);
		builder.append(", addresses=");
		builder.append(addresses);
		builder.append(", notes=");
		builder.append(notes);
		builder.append(", confirmed=");
		builder.append(confirmed);
		builder.append(", lists=");
		builder.append(lists);
		builder.append(", source=");
		builder.append(source);
		builder.append(", emailAddresses=");
		builder.append(emailAddresses);
		builder.append(", prefixName=");
		builder.append(prefixName);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", jobTitle=");
		builder.append(jobTitle);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", customFields=");
		builder.append(customFields);
		builder.append(", sourceDetails=");
		builder.append(sourceDetails);
		builder.append(", workPhone=");
		builder.append(workPhone);
		builder.append(", homePhone=");
		builder.append(homePhone);
		builder.append(", cellPhone=");
		builder.append(cellPhone);
		builder.append(", lastUpdateDate=");
		builder.append("]\n");
		return builder.toString();
	}

	/**
	 * Action By constants for the {@link Contact} type in Constant Contact.
	 * 
	 * @author ConstantContact
	 * 
	 */
	public static final class ActionBy {
		/**
		 * Action by visitor.
		 */
		public static final String ACTION_BY_VISITOR = "ACTION_BY_VISITOR";

		/**
		 * Action by owner.
		 */
		public static final String ACTION_BY_OWNER = "ACTION_BY_OWNER";

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used only as a repository for constants.
		 */
		private ActionBy() {
		}
	}

	/**
	 * Status constants for the {@link Contact} type in Constant Contact.
	 * 
	 * @author ConstantContact
	 */
	public static final class Status {
		/**
		 * Active Status.
		 */
		public static final String ACTIVE = "ACTIVE";

		/**
		 * Unconfirmed Status.
		 */
		public static final String UNCONFIRMED = "UNCONFIRMED";

		/**
		 * Output Status.
		 */
		public static final String OPTOUT = "OPTOUT";

		/**
		 * Removed Status.
		 */
		public static final String REMOVED = "REMOVED";

		/**
		 * Non Subscriber Status.
		 */
		public static final String NON_SUBSCRIBER = "NON_SUBSCRIBER";

		/**
		 * Visitor Status.
		 */
		public static final String VISITOR = "VISITOR";

		/**
		 * Default constructor.<br/>
		 * Made private to prevent instantiation.<br/>
		 * This is unreachable from the outside, since current class is used only as a repository for constants.
		 */
		private Status() {
		}
	}
}
