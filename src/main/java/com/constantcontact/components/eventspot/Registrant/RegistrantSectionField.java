package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * RegistrantSectionField for the Events in Constant Contact.
 *
 * @author ConstantContact
 * @see EventSpotService
 */
public class RegistrantSectionField extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = -1630524753219157747L;

    /**
     * Type of the value - Either 'single_value' or 'multiple_values'
     */
    @JsonIgnore
    private String fieldType;

    /**
     * An array of field values if type = multiple_values
     */
    @JsonIgnore
    private List<String> values;

    /**
     * Name of the field
     */
    @JsonIgnore
    private String name;

    /**
     * Field value if type = single_value
     */
    @JsonIgnore
    private String value;

    /**
     * The label.
     */
    @JsonIgnore
    private String label;

    /**
     * Get the field type.
     *
     * @return The {@link #fieldType}
     */
    @JsonProperty("field_type")
    public String getFieldType() {
        return fieldType;
    }

    /**
     * Get the values.
     *
     * @return The {@link #values}
     */
    @JsonProperty("values")
    public List<String> getValues() {
        return values;
    }

    /**
     * Get the name.
     *
     * @return The {@link #name}
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Get the value.
     *
     * @return The {@link #value}
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Get the label.
     *
     * @return The {@link #label}
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }


    /**
     * Set the field type.
     *
     * @param fieldType The field type.
     */
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    /**
     * Set the values.
     *
     * @param values The values.
     */
    public void setValues(List<String> values) {
        this.values = values;
    }

    /**
     * Set the name.
     *
     * @param name The name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the value.
     *
     * @param value The value.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Set the label.
     *
     * @param label The label.
     */
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
