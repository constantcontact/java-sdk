package com.constantcontact.v2.campaigns;

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
public class SentToContactList implements Serializable {
    @JsonProperty("id")
    protected String _id;

    public SentToContactList() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        _id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SentToContactList)) {
            return false;
        } else {
            SentToContactList rhs = (SentToContactList) obj;
            return new EqualsBuilder()
                    .append(_id, rhs.getId())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_id)
                .hashCode();
    }
}
