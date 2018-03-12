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
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

/**
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class ContactList implements Serializable {
    public static Comparator<ContactList> ListSizeComparator = new Comparator<ContactList>() {
        @Override
        public int compare(ContactList lhs, ContactList rhs) {
            if (lhs.getContactCount() > rhs.getContactCount()) return 1;
            if (lhs.getContactCount() < rhs.getContactCount()) return -1;
            return 0;
        }
    };

   @JsonProperty("contact_count")
    protected int _contactCount;

   @JsonProperty("created_date")
    protected Date _createdDate;

   @JsonProperty("id")
    protected String _id;

   @JsonProperty("modified_date")
    protected Date _modifiedDate;

   @JsonProperty("name")
    protected String _name;

   @JsonProperty("status")
    protected ContactListStatus _status;

    public ContactList() {
    }

    public int getContactCount() {
        return _contactCount;
    }

    public void setContactCount(int contactCount) {
        _contactCount = contactCount;
    }

    public Date getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public ContactListStatus getStatus() {
        return _status;
    }

    public void setStatus(ContactListStatus status) {
        _status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContactList)) {
            return false;
        } else {
            ContactList rhs = (ContactList) obj;
            return new EqualsBuilder()
                    .append(_contactCount, rhs.getContactCount())
                    .append(_createdDate, rhs.getCreatedDate())
                    .append(_id, rhs.getId())
                    .append(_modifiedDate, rhs.getModifiedDate())
                    .append(_name, rhs.getName())
                    .append(_status, rhs.getStatus())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_contactCount)
                .append(_createdDate)
                .append(_id)
                .append(_modifiedDate)
                .append(_name)
                .append(_status)
                .hashCode();
    }
}
