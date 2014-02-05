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


    private static final long serialVersionUID = 7638781369557796006L;

    @JsonIgnore
    private String label;
    @JsonIgnore
    private List<RegistrantSectionField> fields;

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("fields")
    public List<RegistrantSectionField> getFields() {
        return fields;
    }

    public void setLabel(String label) {
        this.label = label;
    }

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
