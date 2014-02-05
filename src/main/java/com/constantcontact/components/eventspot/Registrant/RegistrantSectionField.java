package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class RegistrantSectionField extends Component implements Serializable {


    private static final long serialVersionUID = -1630524753219157747L;


    @JsonIgnore
    private String fieldType;
    @JsonIgnore
    private String values;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private String value;
    @JsonIgnore
    private String label;

    @JsonProperty("field_type")
    public String getFieldType() {
        return fieldType;
    }

    @JsonProperty("values")
    public String getValues() {
        return values;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("RegistrantSectionField [");
        builder.append(" label=");
        builder.append(label);
        builder.append(", field_type=");
        builder.append(fieldType);
        builder.append(", values=");
        builder.append(values);
        builder.append(", name=");
        builder.append(name);
        builder.append(", value=");
        builder.append(value);
        builder.append(", label=");
        builder.append(label);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Default constructor
     */

    public RegistrantSectionField() {
        super();
    }
}
