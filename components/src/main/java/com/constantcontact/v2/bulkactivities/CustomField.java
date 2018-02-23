package com.constantcontact.v2.bulkactivities;

import com.constantcontact.v2.campaigns.ClickThroughDetail;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Custom fields (up to 15)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CustomField implements Serializable {

    @JsonProperty("name")
    protected String _name;

    @JsonProperty("value")
    protected String _value;


    /**
     * Class Creator
     */
    public CustomField() {
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        _value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CustomField)) {
            return false;
        } else {
            CustomField rhs = (CustomField) obj;
            return new EqualsBuilder()
                    .append(_name, rhs.getName())
                    .append(_value, rhs.getValue())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_name)
                .append(_value)
                .hashCode();
    }
}
