package com.constantcontact.v2.contacts;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @author woogienoogie
 */
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class ContactListMetaData implements Serializable {
    @JsonProperty("id")
    protected String _id;

    @JsonProperty("status")
    protected ContactListStatus _status;

    public ContactListMetaData() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
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

        if (!(obj instanceof ContactListMetaData)) {
            return false;
        } else {
            ContactListMetaData rhs = (ContactListMetaData) obj;
            return new EqualsBuilder()
                    .append(_id, rhs.getId())
                    .append(_status, rhs.getStatus())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_id)
                .append(_status)
                .hashCode();
    }
}
