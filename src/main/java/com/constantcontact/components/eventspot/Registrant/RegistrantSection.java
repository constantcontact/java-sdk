package com.constantcontact.components.eventspot.Registrant;

import com.constantcontact.components.Component;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author Stefan Halus <stefan.halus@osf-global.com>
 */
public class RegistrantSection extends Component implements Serializable {

    /**
     * Serial version unique identifier.
     */
    private static final long serialVersionUID = 7638781369557796006L;

    /**
     * The label.
     */
    @JsonIgnore
    private String label;

    /**
     * The list of fields displayed.
     */
    @JsonIgnore
    private List<RegistrantSectionField> fields;

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
     * Get the fields.
     *
     * @return The {@link #fields}
     */
    @JsonProperty("fields")
    public List<RegistrantSectionField> getFields() {
        return fields;
    }

    /**
     * Set the label.
     *
     * @param label The label.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Set the fields.
     *
     * @param fields The fields.
     */
    public void setFields(List<RegistrantSectionField> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("RegistrantSection [");
        builder.append(" label=");
        builder.append(label);
        builder.append(", fields=");
        builder.append(fields);
        builder.append("]");

        return builder.toString();
    }

    /**
     * Default constructor
     */
    public RegistrantSection() {
        super();
    }

}
