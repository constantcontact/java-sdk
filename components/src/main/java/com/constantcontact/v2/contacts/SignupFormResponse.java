/*
 * Copyright (c) 2016 Constant Contact, Inc. All Rights Reserved.
 * Boston, MA 02451, USA
 * Phone: (781) 472-8100
 * Fax: (781) 472-8101
 * This software is the confidential and proprietary information
 * of Constant Contact, Inc. created for Constant Contact, Inc.
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Constant Contact, Inc.
 */

package com.constantcontact.v2.contacts;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Generated response from the server after requesting a signup form.
 * @see <a href="http://developer.constantcontact.com/docs/signup-forms-tools/signup-form-creation.html">Signup Form Creation</a>
 *
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
public class SignupFormResponse implements Serializable {
    @JsonProperty("source")
    private String _source;

    @JsonProperty("list_name")
    private String _listName;

    @JsonProperty("signup_form_url")
    private String _signupFormUrl;

    @JsonProperty("contact_lists")
    private String[] _contactLists;

    public String getSource() {
        return _source;
    }

    public void setSource(String source) {
        _source = source;
    }

    public String getListName() {
        return _listName;
    }

    public void setListName(String listName) {
        _listName = listName;
    }

    public String getSignupFormUrl() {
        return _signupFormUrl;
    }

    public void setSignupFormUrl(String signupFormUrl) {
        _signupFormUrl = signupFormUrl;
    }

    public String[] getContactLists() {
        return _contactLists;
    }

    public void setContactLists(String[] contactLists) {
        _contactLists = contactLists;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SignupFormResponse)) {
            return false;
        } else {
            SignupFormResponse rhs = (SignupFormResponse) obj;
            return new EqualsBuilder()
                    .append(_source, rhs.getSource())
                    .append(_listName, rhs.getListName())
                    .append(_signupFormUrl, rhs.getSignupFormUrl())
                    .append(_contactLists, rhs.getContactLists())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_source)
                .append(_listName)
                .append(_signupFormUrl)
                .append(_contactLists)
                .hashCode();
    }
}
