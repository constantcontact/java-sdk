package com.constantcontact.v2.library;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @author ngalbrai
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class FileUploadStatus implements Serializable {
    @JsonProperty("status")
    protected FileStatus _status;

    @JsonProperty("description")
    protected String _description;

    @JsonProperty("file_id")
    protected long _id;

    public FileUploadStatus() {
    }

    public FileStatus getStatus() {
        return _status;
    }

    public void setStatus(FileStatus status) {
        _status = status;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FileUploadStatus)) {
            return false;
        } else {
            FileUploadStatus rhs = (FileUploadStatus) obj;
            return new EqualsBuilder()
                    .append(_status, rhs.getStatus())
                    .append(_description, rhs.getDescription())
                    .append(_id, rhs.getId())
                    .isEquals();
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(_status)
                .append(_description)
                .append(_id)
                .hashCode();
    }
}
