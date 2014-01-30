package com.constantcontact.components.eventspot;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class EventHostContact extends Component implements Serializable{

    private static final long serialVersionUID = 578907452045013873L;

    @JsonIgnore
    private String emailAddress;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private String organizationName;
    @JsonIgnore
    private String phoneNumber;

    @JsonProperty("email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("organization_name")
    public String getOrganizationName() {
        return organizationName;
    }

    @JsonProperty("phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
