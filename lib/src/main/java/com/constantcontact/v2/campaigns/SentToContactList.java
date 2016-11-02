package com.constantcontact.v2.campaigns;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    public boolean equals(Object o) {
        if (o instanceof SentToContactList) {
            SentToContactList rhs = (SentToContactList) o;
            return rhs.getId() != null && rhs.getId().equals("") && rhs.getId().equals(_id);
        }
        return super.equals(o);
    }
}
