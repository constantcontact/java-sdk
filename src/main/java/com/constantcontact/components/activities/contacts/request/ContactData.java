package com.constantcontact.components.activities.contacts.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.constantcontact.components.Component;
import com.constantcontact.services.activities.BulkActivitiesService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contact Data for the Bulk Activities in Constant Contact.
 * 
 * @see BulkActivitiesService
 * @author ConstantContact
 * 
 */
public class ContactData extends Component implements Serializable {

	/**
	 * Serial version unique identifier.
	 */
	private static final long serialVersionUID = 529360679712024326L;

	@JsonIgnore
	private List<String> emailAddresses;

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
	private String homePhone;

	@JsonIgnore
	private String workPhone;

	@JsonIgnore
	private List<Address> addresses;

	@JsonIgnore
	private List<CustomField> customFields;

    @JsonIgnore
    private String birthday;

    @JsonIgnore
    private String birthdayMonth;

    @JsonIgnore
    private String anniversary;

	/**
	 * Get the email addresses.
	 * 
	 * @return The email addresses.
	 */
	@JsonProperty("email_addresses")
	public List<String> getEmailAddresses() {
		return emailAddresses;
	}

	/**
	 * Get the first name.
	 * 
	 * @return The first name.
	 */
	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName != null ? firstName : "";
	}

	/**
	 * Get the middle name.
	 * 
	 * @return The middle name.
	 */
	@JsonProperty("middle_name")
	public String getMiddleName() {
		return middleName != null ? middleName : "";
	}

	/**
	 * Get the last name.
	 * 
	 * @return The last name.
	 */
	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	/**
	 * Get the job title.
	 * 
	 * @return The job title.
	 */
	@JsonProperty("job_title")
	public String getJobTitle() {
		return jobTitle  != null ? jobTitle : "";
	}

	/**
	 * Get the company name.
	 * 
	 * @return The company name.
	 */
	@JsonProperty("company_name")
	public String getCompanyName() {
		return companyName != null ? companyName : "";
	}

	/**
	 * Get the home phone.
	 * 
	 * @return The home phone.
	 */
	@JsonProperty("home_phone")
	public String getHomePhone() {
		return homePhone != null ? homePhone : "";
	}

	/**
	 * Get the work phone.
	 * 
	 * @return The work phone.
	 */
	@JsonProperty("work_phone")
	public String getWorkPhone() {
		return workPhone != null ? workPhone : "";
	}

	/**
	 * Get the addresses.
	 * 
	 * @return The addresses.
	 */
	@JsonProperty("addresses")
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * Get the custom fields.
	 * 
	 * @return The custom fields.
	 */
	@JsonProperty("custom_fields")
	public List<CustomField> getCustomFields() {
		return customFields;
	}

    /**
     * Get the birthday.
     *
     * @return The birthday.
     */
    @JsonProperty("birthday_day")
    public String getBirthday() {
        return birthday;
    }

    /**
     * Get the birthdayMonth.
     *
     * @return The birthdayMonth.
     */
    @JsonProperty("birthday_month")
    public String getBirthdayMonth() {
        return birthdayMonth;
    }

    /**
     * Get the anniversary.
     *
     * @return The anniversary.
     */
    @JsonProperty("anniversary")
    public String getAnniversary() {
        return anniversary;
    }

    /**
	 * Set the email Addresses.
	 * 
	 * @param emailAddresses New email Addresses.
	 */
	public void setEmailAddresses(List<String> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	/**
	 * Set the first Name.
	 * 
	 * @param firstName New first Name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Set the middle Name.
	 * 
	 * @param middleName The new middle Name.
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Set the last Name.
	 * 
	 * @param lastName The new last Name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Set the job Title.
	 * 
	 * @param jobTitle The new job Title.
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * Set the Company Name
	 * 
	 * @param companyName The new Company Name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Set the Home Phone
	 * 
	 * @param homePhone The new Home Phone
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * Set the Work Phone
	 * 
	 * @param workPhone The new Work Phone
	 */
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	/**
	 * Set the addresses
	 * 
	 * @param addresses The new addresses
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * Set the Custom Fields
	 * 
	 * @param customFields The new Custom Fields
	 */
	public void setCustomFields(List<CustomField> customFields) {
		this.customFields = customFields;
	}

    /**
     * Set the Birthday
     *
     * @param birthday The new Birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Set the Birthday Month
     *
     * @param birthdayMonth The new Birthday Month
     */
    public void setBirthdayMonth(String birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    /**
     * Set the Anniversary
     *
     * @param anniversary The new Anniversary
     */
    public void setAnniversary(String anniversary) {
        this.anniversary = anniversary;
    }

    /**
	 * Default constructor.
	 */
	public ContactData() {
		super();
		this.setEmailAddresses(new ArrayList<String>());
		this.setAddresses(new ArrayList<Address>());
		this.setCustomFields(new ArrayList<CustomField>());
	}

	/**
	 * Custom implementation for {@link Object#toString()}.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactData [emailAddresses=");
		builder.append(emailAddresses);
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
		builder.append(", homePhone=");
		builder.append(homePhone);
		builder.append(", workPhone=");
		builder.append(workPhone);
		builder.append(", addresses=");
		builder.append(addresses);
		builder.append(", customFields=");
		builder.append(customFields);
        builder.append(", birthday=");
        builder.append(birthday);
        builder.append(", birthdayMonth=");
        builder.append(birthdayMonth);
        builder.append(", anniversary=");
        builder.append(anniversary);
		builder.append("]");
		return builder.toString();
	}
}
