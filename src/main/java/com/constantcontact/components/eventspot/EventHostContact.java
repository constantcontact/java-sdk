package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventHostContact extends Component implements Serializable{

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = 578907452045013873L;

    /**
     * Event contact's email-address
     */
    @JsonIgnore
    private String emailAddress;

    /**
     * Name of the person conducting or managing the event
     */
    @JsonIgnore
    private String name;

    /**
     * Event contact's organization name
     */
    @JsonIgnore
    private String organizationName;

    /**
     * Event contact's phone number
     */
    @JsonIgnore
    private String phoneNumber;

    /**
     * Get the emailAddress.
     *
     * @return The {@link #emailAddress}
     */
    @JsonProperty("email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Get the name.
     *
     * @return The {@link #name}
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Get the organizationName.
     *
     * @return The {@link #organizationName}
     */
    @JsonProperty("organization_name")
    public String getOrganizationName() {
        return organizationName;
    }

    /**
     * Get the phoneNumber.
     *
     * @return The {@link #phoneNumber}
     */
    @JsonProperty("phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * Set emailAddress
     *
     * @param emailAddress New value for {@link #emailAddress}
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    /**
     * Set name
     *
     * @param name New value for {@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Set organizationName
     *
     * @param organizationName New value for {@link #organizationName}
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }


    /**
     * Set phoneNumber
     *
     * @param phoneNumber New value for {@link #phoneNumber}
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Default constructor.
     */
    public EventHostContact() {
        super();

    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("Contact [name=");
        builder.append(name);
        builder.append(", emailAddress=");
        builder.append(emailAddress);
        builder.append(", organizationName=");
        builder.append(organizationName);
        builder.append(", phoneNumber=");
        builder.append(phoneNumber);
        builder.append("]");

        return builder.toString();

    }
}
