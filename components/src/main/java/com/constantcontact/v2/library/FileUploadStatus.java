package com.constantcontact.v2.library;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
}
