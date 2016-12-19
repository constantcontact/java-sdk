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
public class CustomField implements Serializable {
    @JsonProperty("name")
    protected String _name;

    @JsonProperty("label")
    protected String _label;

    @JsonProperty("value")
    protected String _value;

    public CustomField() {
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getLabel() {
        return _label;
    }

    public void setLabel(String label) {
        _label = label;
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
                    .append(_label, rhs.getLabel())
                    .append(_value, rhs.getValue())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_name)
                .append(_label)
                .append(_value)
                .hashCode();
    }
}
