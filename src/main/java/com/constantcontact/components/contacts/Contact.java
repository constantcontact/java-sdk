package com.constantcontact.components.contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single Contact in Constant Contact.
 * 
 * @author ConstantContact
 *
 */
public class Contact extends Component implements Serializable {
	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = -2361771080992020447L;

	@JsonIgnore private int id;
	@JsonIgnore private String status;
	@JsonIgnore private String fax;
	@JsonIgnore private List<Address> addresses;
	@JsonIgnore private List<Note> notes;
	@JsonIgnore private boolean confirmed;
	@JsonIgnore private List<ContactList> lists;
	@JsonIgnore private String source;
	@JsonIgnore private List<EmailAddress> emailAddresses;
	@JsonIgnore private String prefixName;
	@JsonIgnore private String firstName;
	@JsonIgnore private String middleName;
	@JsonIgnore private String lastName;
	@JsonIgnore private String jobTitle;
	@JsonIgnore private String departmentName;
	@JsonIgnore private String companyName;
	@JsonIgnore private List<CustomField> customFields;
	@JsonIgnore private String sourceDetails;
	@JsonIgnore private String actionBy;
	@JsonIgnore private String workPhone;
	@JsonIgnore private String homePhone;
	@JsonIgnore private String cellPhone;
	@JsonIgnore private String sourceIsUrl;

	/**
	 * Gets the id.
	 * @return The id.
	 */
	@JsonProperty("id")
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 * @param id <code>Contact</code> id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the status.
	 * @return The status.
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 * @param status The status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Gets the fax number.
	 * @return The fax number.
	 */
	@JsonProperty("fax")
	public String getFax() {
		return fax;
	}
	
	/**
	 * Sets the fax number.
	 * @param fax The fax number.
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * Gets the addresses.
	 * @return The addresses.
	 */
	@JsonProperty("addresses")
	public List<Address> getAddresses() {
		return addresses;
	}
	
	/**
	 * Sets the addresses.
	 * @param addresses The addresses.
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	/**
	 * Gets the notes.
	 * @return The notes.
	 */
	@JsonProperty("notes")
	public List<Note> getNotes() {
		return notes;
	}
	
	/**
	 * Sets the notes.
	 * @param notes The notes.
	 */
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	/**
	 * Gets the confirmation flag;
	 * @return The confirmation flag.
	 */
	@JsonProperty("confirmed")
	public boolean isConfirmed() {
		return confirmed;
	}
	
	/**
	 * Sets the confirmation flag.
	 * @param confirmed The confirmation flag.
	 */
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	/**
	 * Gets the lists.
	 * @return The lists.
	 */
	@JsonProperty("lists")
	public List<ContactList> getLists() {
		return lists;
	}
	
	/**
	 * Sets the lists.
	 * @param lists The lists.
	 */
	public void setLists(List<ContactList> lists) {
		this.lists = lists;
	}
	
	/**
	 * Gets the source.
	 * @return The source.
	 */
	@JsonProperty("source")
	public String getSource() {
		return source;
	}
	
	/**
	 * Sets the source.
	 * @param source The source.
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Gets the email addresses.
	 * @return The email addresses.
	 */
	@JsonProperty("email_addresses")
	public List<EmailAddress> getEmailAddresses() {
		return emailAddresses;
	}
	
	/**
	 * Sets the email addresses.
	 * @param emailAddresses The email addresses. 
	 */
	public void setEmailAddresses(List<EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	
	/**
	 * Gets the prefix name.
	 * @return The prefix name.
	 */
	@JsonProperty("prefix_name")
	public String getPrefixName() {
		return prefixName;
	}
	
	/**
	 * Sets the prefix name.
	 * @param prefixName The prefix name.
	 */
	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
	}
	
	/**
	 * Gets the first name.
	 * @return The first name.
	 */
	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name.		
	 * @param firstName The first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the middle name.
	 * @return The middle name.
	 */
	@JsonProperty("middle_name")
	public String getMiddleName() {
		return middleName;
	}
	
	/**
	 * Sets the middle name.		
	 * @param middleName The middle name.
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	/**
	 * Gets the last name.
	 * @return The last name.
	 */
	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name.
	 * @param lastName The last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the job title.
	 * @return The job title.
	 */
	@JsonProperty("job_title")
	public String getJobTitle() {
		return jobTitle;
	}
	
	/**
	 * Sets the job title.
	 * @param jobTitle The job title.
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	/**
	 * Gets the department name.
	 * @return The department name.
	 */
	@JsonProperty("department_name")
	public String getDepartmentName() {
		return departmentName;
	}
	
	/**
	 * Sets the department name.
	 * @param departmentName The department name.
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	/**
	 * Gets the company name.
	 * @return The company name.
	 */
	@JsonProperty("company_name")
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * Sets the company name.
	 * @param companyName The company name.
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * Gets the list of custom fields.
	 * @return The list of custom fields.
	 */
	@JsonProperty("custom_fields")
	public List<CustomField> getCustomFields() {
		return customFields;
	}
	
	/**
	 * Sets the list of custom fields.
	 * @param customFields The list of custom fields.
	 */
	public void setCustomFields(List<CustomField> customFields) {
		this.customFields = customFields;
	}
	
	/**
	 * Gets the source details.
	 * @return The source details.
	 */
	@JsonProperty("source_details")
	public String getSourceDetails() {
		return sourceDetails;
	}
	
	/**
	 * Sets the source details.
	 * @param sourceDetails The source details.
	 */
	public void setSourceDetails(String sourceDetails) {
		this.sourceDetails = sourceDetails;
	}
	
	/**
	 * Gets action by.
	 * @return Action by.
	 */
	@JsonProperty("action_by")
	public String getActionBy() {
		return actionBy;
	}
	
	/**
	 * Sets action by.
	 * @param actionBy Action by.
	 */
	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}
	
	/**
	 * Gets the work phone.
	 * @return The work phone.
	 */
	@JsonProperty("work_phone")
	public String getWorkPhone() {
		return workPhone;
	}
	
	/**
	 * Sets the work phone.
	 * @param workPhone The work phone.
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	
	/**
	 * Gets the home phone.
	 * @return The home phone.
	 */
	@JsonProperty("home_phone")
	public String getHomePhone() {
		return homePhone;
	}
	
	/**
	 * Sets the home phone.
	 * @param homePhone The home phone.
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * Gets the cell phone.
	 * @return The cell phone.
	 */
	@JsonProperty("cell_phone")
	public String getCellPhone() {
		return cellPhone;
	}
	
	/**
	 * Sets the cell phone.
	 * @param cellPhone The cell phone.
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	/**
	 * Gets the source is url flag.
	 * @return The source is url flag.
	 */
	@JsonProperty("source_is_url")
	public String getSourceIsUrl() {
		return sourceIsUrl;
	}

	/**
	 * Sets the source is url flag.
	 * @param sourceIsUrl The source is url flag.
	 */
	public void setSourceIsUrl(String sourceIsUrl) {
		this.sourceIsUrl = sourceIsUrl;
	}
	
    /**
     * Class constructor.
     */
    public Contact() {
        this.emailAddresses = new ArrayList<EmailAddress>();
        this.addresses = new ArrayList<Address>();
        this.customFields = new ArrayList<CustomField>();
        this.lists = new ArrayList<ContactList>();
        this.notes = new ArrayList<Note>();
    }
    
    /**
     * ActionBy constants.
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
    }
    
    /**
     * Status constants.
     */
    public static final class Status {
    	/**
    	 * Active.
    	 */
    	public static final String ACTIVE = "ACTIVE";
    	
    	/**
    	 * Unconfirmed.
    	 */
    	public static final String UNCONFIRMED = "UNCONFIRMED";
    	
    	/**
    	 * Output.
    	 */
    	public static final String OPTOUT = "OPTOUT";
    	
    	/**
    	 * Removed.
    	 */
    	public static final String REMOVED = "REMOVED";
    	
    	/**
    	 * NonSubscriber.
    	 */
    	public static final String NON_SUBSCRIBER = "NON_SUBSCRIBER";
    	
    	/**
    	 * Visitor.
    	 */
    	public static final String VISITOR = "VISITOR";
    }
}
