package com.constantcontact.v2.contacts;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

/**
 * @author woogienoogie
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
}
