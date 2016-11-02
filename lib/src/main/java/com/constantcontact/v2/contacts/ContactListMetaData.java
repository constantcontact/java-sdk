package com.constantcontact.v2.contacts;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class ContactListMetaData implements Serializable {

    @JsonProperty("id")
    protected String _id;

    @JsonProperty("status")
    protected ContactStatus _status;

    public ContactListMetaData() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    public ContactStatus getStatus() {
        return _status;
    }

    public void setStatus(ContactStatus status) {
        _status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof ContactListMetaData)) {
            return false;
        }

        ContactListMetaData rhs = (ContactListMetaData) o;
        return rhs.getId() != null && !rhs.getId().equals("") && rhs.getId().equals(_id) && rhs.getStatus().equals(_status);
    }
}
